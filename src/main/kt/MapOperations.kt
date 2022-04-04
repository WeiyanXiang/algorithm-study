package kt

/**
 * @author Weiyan Xiang on 2022/2/27
 */
fun main() {
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap.get("one"))
    println(numbersMap["one"])
    println(numbersMap.getOrDefault("four", 10))
    println(numbersMap["five"])               // null
    //numbersMap.getValue("six")      // exception!
    println(numbersMap.keys)
    println(numbersMap.values)

    val filteredKeysMap: Map<String, Int> = numbersMap.filterKeys { it.endsWith("e") }
    println(filteredKeysMap)
    val filteredValuesMap: Map<String, Int> = numbersMap.filterValues { it > 1 }
    println(filteredValuesMap)

    println(numbersMap + Pair("four", 4))
    println(numbersMap + Pair("one", 10))
    println(numbersMap + mapOf("five" to 5, "one" to 11))

    println(numbersMap)
    println(numbersMap - "one")
    println(numbersMap - listOf("two", "four"))

    println(numbersMap + Pair("four", 1) + Pair("two", 222))

}