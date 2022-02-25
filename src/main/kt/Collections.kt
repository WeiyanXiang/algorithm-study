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

    val numbs = listOf("one", "two", "three", "four")
    println(numbs.associateWith { it.length })
    // key: first letter in upper case
    println(numbs.associateBy { it.first().uppercaseChar() })
    // key: first letter in upper case; value: length of word
    println(numbs.associateBy(keySelector = { it.first().uppercaseChar() }, valueTransform = { it.length }))

    /**
     * Note that associate() produces short-living Pair objects which may affect the performance. Thus, associate()
     * should be used when the performance isn't critical or it's more preferable than other options.
     */
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    val pairs: Map<String, String> = names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } }
    println(pairs)

    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())

    val containers = listOf(
        listOf("one", "two", "three"),
        listOf("four", "five", "six"),
        listOf("seven", "eight")
    )
    println(containers.flatMap { it })

    val numsMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numsMap.filter { (k, v) -> k.endsWith("1") && v > 10 }
    println(filteredMap)

    val list = listOf("one", "two", "three", "four")
    val (match, rest) = list.partition { it.length > 3 }
    println(match)
    println(rest)
    println(list.any { it.endsWith("e") })
    println(list.none { it.endsWith("a") })
    println(list.all { it.endsWith("e") })
    // check emptyness
    println(list.any())
    println(list.none())

    val plusList = listOf("1", "2", "3", "4", "5")
    println(plusList + "6")
    println(plusList - "2")

    val toGroup = listOf("one", "two", "three", "four", "five")
    val groupBy: Map<String, List<String>> = toGroup.groupBy { it.first().uppercase() }
    println(groupBy.count())
    val groupBy1: Map<Char, List<String>> =
        toGroup.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() })
    println(groupBy1)

    val toSlice = listOf("one", "two", "three", "four", "five")
    println(toSlice.slice(0..4 step 2))
    println(toSlice.slice(0..4))
    println(toSlice.slice(listOf(3, 4, 0)))

    val toTake = listOf("one", "two", "three", "four", "five", "six")
    println(toTake.take(3))
    println(toTake.takeLast(3))
    println(toTake.drop(1))
    println(toTake.dropLast(5))

    println(toTake.takeWhile { !it.startsWith('f') })
    println(toTake.takeLastWhile { it != "three" })
    println(toTake.dropWhile { it.length == 3 })
    println(toTake.dropLastWhile { it.contains('i') })

    val chunkWindowZip = (0..13).toList()
    println(chunkWindowZip.chunked(3))
    println(chunkWindowZip.windowed(3))
    /**
     * partialWindows includes windows of smaller sizes that start from the elements at the end of the collection. For
     * example, if you request windows of three elements, you can't build them for the last two elements. Enabling
     * partialWindows in this case includes two more lists of sizes 2 and 1.
     */
    println(chunkWindowZip.windowed(3, 1, true))

    println(chunkWindowZip.zipWithNext())
    println(chunkWindowZip.zipWithNext { s1, s2 -> s1 > s2 })
    println(chunkWindowZip.zip(chunkWindowZip))

    val retrieveList = listOf(1, 2, 3, 4, 5)
    println(retrieveList.elementAt(0))
    println(retrieveList.elementAtOrNull(0))
    println(retrieveList.elementAtOrElse(0) { 777 })
    println(retrieveList.first())
    println(retrieveList.last())
    // java.util.NoSuchElementException if no match
    val first: Int = retrieveList.first { it > 3 }
    val firstOrNull: Int? = retrieveList.firstOrNull { it > 8 }

    val lengthComparator = Comparator<String> { s1, s2 -> s1.length - s2.length }
    println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))
    println(listOf("aaa", "bb", "c").sorted())
    println(listOf("aaa", "bb", "c").sortedDescending())
    println(listOf("aaa", "bb", "c").sortedBy { it.length })
    println(listOf("aaa", "bb", "c").reversed())
    println(listOf("aaa", "bb", "c").shuffled())
}

data class FullName(val firstName: String, val lastName: String)

fun parseFullName(fullName: String): FullName {
    val nameParts = fullName.split(" ")
    if (nameParts.size == 2) {
        return FullName(nameParts[0], nameParts[1])
    } else throw Exception("Wrong name format")
}
