package kt

import java.util.*

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
    foo() // bar=0, baz=1
    foo(3) // bar=3, baz=1
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
    its.forEachIndexed { i, it -> println(it[i]) }

    val ss = listOf("kotlin", "programming", "book")
    ss.forEach(::println)
    ss.forEach { s -> println("[$s]") }

    val mutableMap = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    mutableMap.put(4, "d")


    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { t, u -> println("$t -> $u") }

}






