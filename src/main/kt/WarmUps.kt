package kt

import junit.framework.Assert.assertEquals
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Weiyan Xiang on 2021/3/5
 */

fun sum(l: Int, r: Int): Int = l + r

fun printSum(l: Int, r: Int) = println("sum of $l and $r is ${l + r}")

fun main(args: Array<String>) {
    print(sum(1, 2))
    printSum(1, 2)
    foo(baz = 2) // The default value bar = 0 is used

    println(testListWithRefPassedInWhichIsWrong)
    println(testListWithSpread)

    var num1 = 1
    println(num1 doAdd 2 == num1.doAdd(2))

    testRanges()
    testOutMap()

    println(myLazyVal)
    println(myLazyVal)

    whenGetItUsingPublication_thenCouldInitializeItMoreThanOnce()
    testLateInit()
}

fun practice() {
    // read-only
    val a: Int = 1
    val b = 2
    val c: Int
    c = 3

    var x = 1
    x++
    val name: String? = null

    when (name) {
        null -> println("null")
        "a" -> println("a => $name")
        else -> println(name)
    }
}

// default value
fun read(
        b: ByteArray,
        a: Int = 0,
        c: Int = 1
) = a + c

open class A {
    open fun foo(i: Int = 10) { /*...*/
    }
}

class B : A() {
    override fun foo(i: Int) { /*...*/
    }  // No default value is allowed.
}

fun foo(
        bar: Int = 0,
        baz: Int = 1
) {
    bar + baz
}

/**
https://kotlinlang.org/docs/functions.html#default-arguments
 */
fun testFoo() {
    // check null otherwise
    var map = mutableMapOf<String, String>()
    map.put("2", "3")
    val test = map["2"] ?: "2"

    foo() // bar=0, baz=1
    foo(bar = 3) // bar=3, baz=1
    fooWithLambda(1) { println("hello") }     // Uses the default value baz = 1
    fooWithLambda(qux = { println("hello") }) // Uses both default values bar = 0 and baz = 1
    fooWithLambda { println("hello") }        // Uses both default values bar = 0 and baz = 1
    fooWithLambda(ints = *intArrayOf(1, 2)) { println("hello") }
    /**
     * On the JVM: You can't use the named argument syntax when calling Java functions because Java bytecode does not
     * always preserve names of function parameters.
     */
    fooWithLambda(bar = 10, baz = 20, ints = *intArrayOf(1, 2)) { println("hello") }
}

fun fooWithLambda(
        bar: Int = 0,
        baz: Int = 1,
        vararg ints: Int,
        qux: () -> Unit
) { /*...*/
}

fun <T> asList(vararg ts: T) {
    val res = ArrayList<T>()
    for (t in ts) {
        res.add(t)
    }
    println(res)
}

val initialList = arrayOf(4, 5, 6)
val testListWithRefPassedInWhichIsWrong = asList(1, 2, initialList, 7)
val testListWithSpread = asList(1, 2, *initialList, 7)

infix fun Int.doAdd(x: Int) = this + x


/**
 * https://kotlinlang.org/docs/functions.html#local-functions
 * - Local functions
 * - Member functions
 * - Generic functions﻿
 * - Tail recursive functions
 */

// When a function is marked with the tailrec modifier and meets the required form, the compiler optimizes out the
// recursion, leaving behind a fast and efficient loop based version instead

val eps = 1E-10

tailrec fun findFixPoint(x: Double = 1.0): Double =
        if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

// above equals to below
private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (Math.abs(x - y) < eps) return x
        x = Math.cos(x)
    }
}

// collections & iterations
fun testCollections(): Unit {
    val its = arrayOf("kotlin", "programming", "book")
    println(its[0])
    println(its.get(0))
    println(its.size)

    its.forEach { it -> println(it) }
    its.forEach(::println)
    its.forEachIndexed { i, element -> println(element[i]) }

    val ss = listOf("kotlin", "programming", "book")
    ss.forEach(::println)
    ss.forEach { s -> println("[$s]") }

    val mutableMap = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    mutableMap[4] = "d"


    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { t, u -> println("$t -> $u") }

}

fun testRanges() {
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("out of range")
    }
    if (2 in 0..list.lastIndex) {
        println("within range")
    }
    for (i in 9 downTo 1 step 4) {
        println(i)
    }
    for (i in 1..10 step 3) {
        println(i)
    }

}

fun testOutMap() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println("map testing:")
    println(map["a"])
    println(map.getValue("a"))
    println(map["c"])
    println(map["d"])

    map.forEach { k, v -> println("$k - $v") }

    for ((k, v) in map) {
        println("$k - $v")
    }

}

/**
 * https://kotlinlang.org/docs/delegated-properties.html#lazy-properties
 *
 * https://www.baeldung.com/kotlin/lazy-initialization
 *
 * We can see that using the lazy initialization pattern in Java is quite cumbersome. We need to write a lot of
 * boilerplate code to achieve our goal. Luckily, the Kotlin language has built-in support for lazy initialization.
 */
val myLazyVal: String by lazy {
    println("done once, should not see twice this message")
    "Hello"
}

class ClassWithHeavyInitialization


fun whenGetItUsingPublication_thenCouldInitializeItMoreThanOnce() {
    println("Test LazyThreadSafetyMode:")
    // given
    val numberOfInitializations: AtomicInteger = AtomicInteger()
    /**
     * We can pass a PUBLICATION as a mode – which will cause that every thread can initialize given property.
     * The object assigned to the reference will be the first returned value – so the first thread wins.
     */
    val lazyValue: ClassWithHeavyInitialization
            by lazy(LazyThreadSafetyMode.PUBLICATION) {
                numberOfInitializations.incrementAndGet()
                println(numberOfInitializations)
                ClassWithHeavyInitialization()
            }
    val executorService = Executors.newFixedThreadPool(2)
    val countDownLatch = CountDownLatch(1)

    // when
    executorService.submit { countDownLatch.await(); println(lazyValue) }
    executorService.submit { countDownLatch.await(); println(lazyValue) }
    countDownLatch.countDown()

    // then
    executorService.awaitTermination(1, TimeUnit.SECONDS)
    executorService.shutdown()
    assertEquals(numberOfInitializations.get(), 2)
}

fun testLateInit() {
    lateinit var a: String
    // println(a) // Exception in thread "main" kotlin.UninitializedPropertyAccessException: lateinit property a has not been initialized
    a = "a"
    println(a)
}






