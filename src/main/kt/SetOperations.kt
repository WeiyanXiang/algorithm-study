package kt

/**
 * @author Weiyan Xiang on 2022/2/27
 */
fun main() {
    val numbers = setOf("one", "two", "three")
    println(numbers union setOf("four", "five"))
    println(numbers subtract setOf("four", "five"))
    println(numbers intersect setOf("four", "five"))
}