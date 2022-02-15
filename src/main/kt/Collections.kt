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

}
