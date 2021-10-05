https://draveness.me/kubernetes-statefulset/#:~:text=StatefulSet%20%E6%98%AFKubernetes%20%E4%B8%BA%E4%BA%86%E5%A4%84%E7%90%86,%E7%9A%84%E6%9C%89%E7%8A%B6%E6%80%81%E7%B3%BB%E7%BB%9F%EF%BC%8C%E4%BE%8B%E5%A6%82
详解 Kubernetes StatefulSet 实现原理
在 Kubernetes 的世界中，ReplicaSet 和 Deployment 主要用于处理无状态的服务，无状态服务的需求往往非常简单并且轻量，每一个无状态节点
存储的数据在重启之后就会被删除，虽然这种服务虽然常见，但是我们仍然需要有状态的服务来实现一些特殊的需求，StatefulSet 就是 Kubernetes 
为了运行有状态服务引入的资源，例如 Zookeeper、Kafka 等。

这篇文章会介绍 Kubernetes 如何在集群中运行有状态服务，同时会分析这些有状态服务 StatefulSet 的同步过程以及实现原理。

概述
StatefulSet 是用于管理有状态应用的工作负载对象，与 ReplicaSet 和 Deployment 这两个对象不同，StatefulSet 不仅能管理 Pod 的对象，
还它能够保证这些 Pod 的顺序性和唯一性。

与 Deployment 一样，StatefulSet 也使用规格中声明的 template 模板来创建 Pod 资源，但是这些 Pod 相互之间是不能替换的；除此之外 
StatefulSet 会为每个 Pod 设置一个单独的持久标识符，这些用于标识序列的标识符在发生调度时也不会丢失。

```
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: web
spec:
  serviceName: "nginx"
  replicas: 2
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: k8s.gcr.io/nginx-slim:0.8
        volumeMounts:
        - name: www
          mountPath: /usr/share/nginx/html
  volumeClaimTemplates:
  - metadata:
      name: www
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
```

实现原理
与 ReplicaSet 和 Deployment 资源一样，StatefulSet 也使用控制器的方式实现，它主要由 StatefulSetController、StatefulSetControl 和 StatefulPodControl 三个组件协作来完成 StatefulSet 的管理，StatefulSetController 会同时从 PodInformer 和 ReplicaSetInformer 中接受增删改事件并将事件推送到队列中：