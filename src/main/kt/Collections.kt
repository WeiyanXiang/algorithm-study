package kt

/**
 * @author Weiyan Xiang on 2022/2/15
 */

fun main() {
    for (i in 1..8 step 2) println(i)
    for (i in 4 downTo 1) println(i)
    for (i in (1..4).reversed()) println(i)

    val numbersSequence = sequenceOf("four", "three", "two", "one")
    val numbers = listOf("one", "two", "three", "four")
    val numbersSeq = numbers.asSequence()

    // seed is the first element
    val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element
    println(oddNumbers.take(5).toList())


    val yieldNums = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(yieldNums.take(6).toList())

    /**
     * The output of this code shows that the filter() and map() functions are called only when building the result list.
     * So, you first see the line of text “Lengths of..” and then the sequence processing starts. Note that for elements
     * left after filtering, the map executes before filtering the next element. When the result size reaches 4, the
     * processing stops because it's the largest possible size that take(4) can return.
     */
    val words = "this is a biggest tests for processing sequence vs lists".split(" ")
    words.asSequence().filter {
        println("filter: $it")
        it.length > 3
    }.map {
        println("length: ${it.length}")
        it.length
    }.take(4).apply {
        println(this.toList())
    }

    val nums: Set<Int?> = setOf(1, 2, 3, null)
    nums.mapIndexed { i, v -> println("index:$i, value:$v") }
    nums.mapIndexedNotNull() { i, v -> println("index:$i, value:$v") }

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    numbersMap.mapKeys { it.key.uppercase() }.also { println(it) }
    numbersMap.mapValues { it.value * it.value }.also { println(it) }

    /**
     * If the collections have different sizes, the result of the zip() is the smaller size; the last elements of the
     * larger collection are not included in the result.
     */
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    val zippedAnimals: List<Pair<String, String>> = colors.zip(animals)
    println(zippedAnimals)

    val twoAnimals = listOf("fox", "bear")
    val zippedAnimalsWithFewer = colors zip twoAnimals
    println(zippedAnimalsWithFewer)

    // When you have a List of Pairs, you can do the reverse transformation – unzipping – that builds two lists from these pairs
    val numberPairs: List<Pair<String, Int>> = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    val unzip: Pair<List<String>, List<Int>> = numberPairs.unzip()
    println(unzip)
}
