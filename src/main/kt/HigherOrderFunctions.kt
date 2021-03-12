package kt

/**
 * @author Weiyan Xiang on 2021/3/12
 */
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if (predicate?.invoke(it) == true) {
            println(it)
        }
    }

}

val predicate1: (String) -> Boolean = {
    it.startsWith("J")
}

fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("J") }
}

fun main(args: Array<String>) {
    val list = listOf("Kotlin", "Java")
    printFilteredStrings(
            list,
            {
                it.startsWith("J")
            }
    )

    printFilteredStrings(list, predicate1)
    printFilteredStrings(list, getPrintPredicate())
    // printFilteredStrings(list, null)
}