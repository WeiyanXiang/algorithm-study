package array;/**
 * @author Weiyan Xiang on 2022/1/3
 */

import java.util.*;

public class TopKFrequentWords {
    /**
     * 692. Top K Frequent Words
     * <p>
     * https://leetcode.com/problems/top-k-frequent-words/
     * <p>
     * my ac ans: map and priorityQueue
     */
    public List<String> topKFrequent(String[] words, int k) {
        // map: <word, frequency>
        // loop map: sort frequency and save into priority queue the entry
        // pop the queue k times and find the word
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (map.containsKey(w)) map.put(w, map.get(w) + 1);
            else map.put(w, 1);
        }
        List<String> ans = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() == e2.getValue() ?
                        e1.getKey().compareTo(e2.getKey()) :
                        e2.getValue() - e1.getValue()
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().getKey());
        }
        return ans;
    }
}
