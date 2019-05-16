package com.mmc.hellokotlin

import com.mmc.strings.joinToString
import com.mmc.strings.lastChar
import com.mmc.strings.printToString
import com.mmc.strings.printToStringString

fun main(args: Array<String>) {
    val set = hashSetOf(1, 3, 5, 7)
    val list = arrayListOf(2, 4, 6, 8)
    val stringList = arrayListOf("a", "b", "c", "d")
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")

    println(set.javaClass)
    println(list.javaClass)
    println(list.javaClass)
    println(list.last())
    println(joinToString(list, ";", "(", ")"))
    System.out.println("kotlin".lastChar())
    System.out.println(set.printToString())
    System.out.println(stringList.printToStringString(separator = "、"))

    println(stringList.last())
    test(arrayOf(1, 2, 3, 4, 5))

    val (key1,value1) = 1.to("one")
    val (key2,value2) = 1 to "one"
}

fun test(args: Array<Int>) {
    val list = listOf(*args)
    println(list)
}

