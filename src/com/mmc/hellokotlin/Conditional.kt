package com.mmc.hellokotlin

/**
 * If语句
 * */

fun conditional_if() {
    val a = 1
    val b = 2

    // 传统用法
    var max = a
    if (a < b) max = b

    // 使用 else
    var max1: Int
    if (a > b) {
        max1 = a
    } else {
        max1 = b
    }

    //我们也可以把 IF 表达式的结果赋值给一个变量。这也说明我也不需要像Java那种有一个三元操作符，因为我们可以使用它来简单实现
    val max2 = if (a > b) a else b

    //我们也可以把 IF 表达式的结果赋值给一个变量
    val max3 = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    //使用区间,使用 in 运算符来检测某个数字是否在指定区间内
    if (a in 1..9) {
        print(a)
    }
}

/**
 * when
 * when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。
 *when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。
 * */

fun conditional_when() {
    //when 类似其他语言的 switch 操作符。其最简单的形式如下：
    val x = 1
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        in 10..20 -> print("x is in 10~20")
        is Int -> x.plus(2)
        else -> {
            print("x!=1 && x!=2")
        }
    }
}
