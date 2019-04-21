package com.mmc.hellokotlin

/**
 * For 循环
 * for 循环可以对任何提供迭代器（iterator）的对象进行遍历，语法如下:
 * for (item in collection) print(item)
 * */
fun main(args: Array<String>) {
    val fruits = arrayListOf("apple", "banana", "watermelon", "peach", "pear")

    //for 可以循环遍历任何提供了迭代器的对象
    for (item: String in fruits) {
        println(item)
    }

    //如果你想要通过索引遍历一个数组或者一个 list，你可以这么做
    for (i in fruits.indices) {
        println("$i : ${fruits[i]}")
    }

    //注意这种"在区间上遍历"会编译成优化的实现而不会创建额外对象。
    //或者你可以用库函数 withIndex：
    for ((index, value) in fruits.withIndex()) {
        println("$index : $value")
    }

    foo()
    println()
    foo1()
    println()
    foo3()
}

/**
 * while 与 do...while 循环
 * 略
 * */

/**
 * 返回和跳转
 * 1.return。默认从最直接包围它的函数或者匿名函数返回
 * 2.break。终止最直接包围它的循环
 * 3.continue。继续下一次最直接包围它的循环
 * */

fun test() {
    for (i in 1..10) {
        if (i == 3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i > 5) break   // i 为 6 时 跳出循环
    }

    //在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签。 要为一个表达式加标签，我们只要在其前加标签即可
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j > 50) break@loop
        }
    }
}

//标签处返回,比较不同
fun foo() {
    val ints = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    print("start")
    ints.forEach {
        if (it == 3) return
        print(it)
    }
    print("end")
}

//如果我们需要从 lambda 表达式中返回，我们必须给它加标签并用以限制 return
fun foo1() {
    val ints = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    print("start")
    ints.forEach for1@{
        if (it == 3) return@for1
        print(it)
    }
    print("end")
}

//通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名
fun foo2() {
    val ints = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    print("start")
    ints.forEach {
        if (it == 3) return@forEach
        print(it)
    }
    print("end")
}

//或者，我们用一个匿名函数替代 lambda 表达式。 匿名函数内部的 return 语句将从该匿名函数自身返回
fun foo3() {
    val ints = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    print("start")
    ints.forEach(fun(value: Int) {
        if (value == 3) return@forEach
        print(value)
    })
    print("end")
}