package kt

/**
 * @author Weiyan Xiang on 2021/3/12
 */
fun main(args: Array<String>) {
    val list = listOf("Kotlin", "Java", "C++", "Javascript")
    list
            .filterNotNull()
//            .filter { it.startsWith("J") }
//            .map { it.length }
            .associate { it to it.length }
//            .take(3)
//            .takeLast(3)
            .forEach {
                println("${it.key}, ${it.value}")
            }

    val map = list.take(3).associate { it to it.length }
    println(map)

    val lang = list.first()
    val langLast = list.last()
//    list.filterNotNull().last()
    val find = list.filterNotNull().find { it.startsWith("X") }.orEmpty()
    println(lang)
    println(find)

}