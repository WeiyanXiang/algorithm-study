package kt

/**
 * @author Weiyan Xiang on 2022/2/27
 */
fun main() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.get(0))
    println(numbers[0])
    //numbers.get(5)                         // exception!
    println(numbers.getOrNull(5))             // null
    println(numbers.getOrElse(5) { it })

    println(numbers.subList(1, 3))
    println(numbers.indexOf(2))
    println(numbers.lastIndexOf(2))

    println(numbers.indexOfFirst { it > 2 })
    println(numbers.indexOfLast { it % 2 == 1 })

    val sortedList = mutableListOf("one", "two", "three", "four")
    sortedList.sort() // [four, one, three, two]
    println(sortedList)
    /**
     * otherwise, it returns (-insertionPoint - 1) where insertionPoint is the index where this element should be
     * inserted so that the list remains sorted. If there is more than one element with the given value,
     * the search can return any of their indices.
     */
    println(sortedList.binarySearch("two"))  // 3
    println(sortedList.binarySearch("z")) // -5
    println(sortedList.binarySearch("two", 0, 2))  // -3


    sortedList.sort()
    println("Sort into ascending: $numbers")
    sortedList.sortDescending()
    println("Sort into descending: $numbers")

    sortedList.sortBy { it.length }
    println("Sort into ascending by length: $numbers")
    sortedList.sortByDescending { it.last() }
    println("Sort into descending by the last letter: $numbers")

    sortedList.sortWith(compareBy<String> { it.length }.thenBy { it })
    println("Sort by Comparator: $numbers")

    sortedList.shuffle()
    println("Shuffle: $numbers")

    sortedList.reverse()
    println("Reverse: $numbers")
}

data class Product(val name: String, val price: Double)

