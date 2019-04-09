package com.mmc.hellokotlin

fun main(args: Array<String>) {
    println(sum(3, 5))
    println(sum1(3, 5))
    println(sum2(3, 5))
    printSum(3, 5)
    printSum1(3, 5)
    vars(1, 2, 3, 4, 5)
    println()
    println(sumLambda(3, 5))
}

/**函数定义使用关键字 fun，参数格式为：参数 : 类型*/
fun sum(a: Int, b: Int): Int {  // Int 参数，返回值 Int
    return a + b
}

/**表达式作为函数体，返回类型自动推断*/
fun sum1(a: Int, b: Int): Int = a + b

// public 方法则必须明确写出返回类型
public fun sum2(a: Int, b: Int): Int = a + b

/**无返回值的函数(类似Java中的void)*/
fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}

// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)
public fun printSum1(a: Int, b: Int) {
    println(a + b)
}

/**函数的变长参数可以用 vararg 关键字进行标识*/
fun vars(vararg v: Int) {
    for (vt in v)
        print(vt)
}

/**lambda(匿名函数)*/
val sumLambda: (Int, Int) -> Int = { x, y -> x + y }