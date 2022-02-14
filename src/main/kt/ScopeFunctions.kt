package kt

import kotlin.random.Random

/**
 * @author Weiyan Xiang on 2022/2/12
 *
 * The Kotlin standard library contains several functions whose sole purpose is to execute a block of code within the
 * context of an object. When you call such a function on an object with a lambda expression provided, it forms a temporary
 * scope. In this scope, you can access the object without its name. Such functions are called scope functions.
 * There are five of them: let, run, with, apply, and also.
 */

class Student(val name: String, var age: Int = 20, var city: String = "") {

    fun moveTo(place: String) {
        city = place
    }

    fun incrementAge() {
        age++
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, city='$city')"
    }
}

fun main() {

    /**
    let, run, and with return the lambda result.
    apply and also return the context object.
     */
    val s1: Student = Student("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
        it
    }

    val s2: Student = Student("Alice", 20, "Amsterdam").run {
        println(this)
        this.city = "London"
        this.age++
        println(this)
        this
    }

    with(mutableListOf("one", "two", "three")) {
        val firstItem = first()
        val lastItem = last()
        println("First item: $firstItem, last item: $lastItem")
    }

    val s3: Student = Student("Alice", 20, "Amsterdam").apply {
        println(this)
        this.city = "London"
        this.age++
        println(this)
    }

    val s4: Student = s2.also {
        it.age++
    }

    letUseCases()

    withUseCases()

    runUseCases()

    applyUseCases()

    alsoUseCases()

    takeUseCases()

}

private fun takeUseCases() {
    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("even: $evenOrNull, odd: $oddOrNull")

    val str = "hello"
    val uppercase: String? = str.takeIf(String::isNotEmpty)?.uppercase()
    println(uppercase)

    displaySubstringPos("test_string_hello", "hello")
}

fun displaySubstringPos(input: String, sub: String) {
    input.indexOf(sub).takeIf { it >= 0 }?.let {
        println("found substring $sub on index $it")
    }
}

private fun alsoUseCases() {
    /**
     * When you see also in the code, you can read it as “ and also do the following with the object.”
     */
    val numbers = mutableListOf("one", "two", "three")
    numbers.also { println("The list elements before adding new one: $it") }.add("four")
}

private fun applyUseCases() {
    /**
     * Use apply for code blocks that don't return a value and mainly operate on the members of the receiver object. The
     * common case for apply is the object configuration. Such calls can be read as
     * “ apply the following assignments to the object.”
     */
    val adam: Student = Student("Adam").apply {
        age = 32
        city = "London"
    }
    println(adam)
}

private fun runUseCases() {
    class MultiportService(var url: String, var port: Int) {
        fun prepareRequest(): String = "Default request"
        fun query(request: String): String = "Result for query '$request'"
    }

    val service = MultiportService("https://example.kotlinlang.org", 80)

    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }

    // the same code written with let() function:
    val letResult = service.let {
        it.port = 8080
        it.query(it.prepareRequest() + " to port ${it.port}")
    }
}

private fun withUseCases() {
    /**
     * We recommend with for calling functions on the context object without providing the lambda result. In the code,
     * with can be read as “ with this object, do the following.”
     *
     * Another use case for with is introducing a helper object whose properties or functions will be used for calculating a value.
     */
    val numbers = mutableListOf("one", "two", "three")
    val firstAndLast: String = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)
}

fun letUseCases() {
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let(::println)
    /**
     *
    let is often used for executing a code block only with non-null values. To perform actions on a non-null object,
    use the safe call operator ?. on it and call let with the actions in its lambda.
     */

    val str: String? = "Hello"
    //processNonNullString(str)       // compilation error: str can be null
    val length = str?.let {
        println("let() called on $it")
        processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }

    /**
     * Another case for using let is introducing local variables with a limited scope for improving code readability.
     * To define a new variable for the context object, provide its name as the lambda argument so that it can be used
     * instead of the default it.
     */
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!$firstItem!"
    }.uppercase()
    println("First item after modifications: '$modifiedFirstItem'")
}

fun processNonNullString(item: String) {
    println("processNonNullString $item")
}


