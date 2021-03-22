#Introduction
Apache Ignite is an open source memory-centric distributed platform. We can use it as a database, a caching system or 
for the in-memory data processing.

The platform uses memory as a storage layer, therefore has impressive performance rate. Simply put, this is one of the 
fastest atomic data processing platforms currently in production use.

#Memory Arch
The platform is based on Durable Memory Architecture. This enables to store and process the data both on disk and in memory. 
It increases the performance by using the RAM resources of the cluster effectively.

The data in memory and on the disk has the same binary representation. This means no additional conversion of the data 
while moving from one layer to another.

Durable memory architecture splits into fixed-size blocks called pages. Pages are stored outside of Java heap and 
organized in a RAM. It has a unique identifier: FullPageId.

Pages interact with the memory using the PageMemory abstraction.

It helps to read, write a page, also to allocate a page id. Inside the memory, Ignite associates pages with Memory Buffers.

#Memory Pages
A Page can have the following states:

- Unloaded – no page buffer loaded in memory
- Clear – the page buffer is loaded and synchronized with the data on disk
- Durty – the page buffer holds a data which is different from the one in disk
- Dirty in checkpoint – there is another modification starts before the first one persists to disk. Here a checkpoint 
starts and PageMemory keeps two memory buffers for each Page.
Durable memory allocates local a memory segment called Data Region. By default, it has a capacity of 20% of the cluster 
memory. Multiple regions configuration allows keeping the usable data in a memory.

The maximum capacity of the region is a Memory Segment. It's a physical memory or a continuous byte array.
To avoid memory fragmentations, a single page holds multiple key-value entries. Every new entry will be added to 
the most optimal page. If the key-value pair size exceeds the maximum capacity of the page, Ignite stores the data in 
more than one page. The same logic applies to updating the data.

SQL and cache indexes are stored in structures known as B+ Trees. Cache keys are ordered by their key values.