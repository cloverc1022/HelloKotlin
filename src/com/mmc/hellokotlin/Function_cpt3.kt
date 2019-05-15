package com.mmc.hellokotlin

import com.mmc.strings.joinToString
import com.mmc.strings.lastChar

fun main(args: Array<String>) {
    val set = hashSetOf(1, 3, 5, 7)
    val list = arrayListOf(2, 4, 6, 8)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")

    println(set.javaClass)
    println(list.javaClass)
    println(list.javaClass)
    println(list.last())
    println(joinToString(list, ";", "(", ")"))
    System.out.println("kotlin".lastChar())
}

