- keyBy
DataStream → KeyedStream #
Logically partitions a stream into disjoint partitions. All records with the same key are assigned to the same partition. 
Internally, keyBy() is implemented with hash partitioning. There are different ways to specify keys.

A type cannot be a key if:

it is a POJO type but does not override the hashCode() method and relies on the Object.hashCode() implementation.
it is an array of any type.