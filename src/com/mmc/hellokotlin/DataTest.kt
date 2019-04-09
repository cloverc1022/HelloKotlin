package com.mmc.hellokotlin

/**
 * 定义常量与变量
 *
 * val   不可变变量定义
 * var   可变变量定义
 *常量与变量都可以没有初始化值,但是在引用前必须初始化
 *编译器支持自动类型判断,即声明时可以不指定类型,由编译器判断
 * */
val a: Int = 1
val b = 1   // 系统自动推断变量类型为Int
fun main() {
    val a: Int // 如果不在声明时初始化则必须提供变量类型
    a = 1      // 明确赋值
    print(a)
}

/**
 *字符串模板
 *
 * $ 表示一个变量名或者变量值
 *$varName 表示变量值
 *${varName.fun()} 表示变量的方法返回值
 * */
fun main1() {
    var a = 1
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")},but now is $a"
}

/**
 * NULL检查机制
 *Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，
 * 字段后加!!像Java一样抛出空异常，另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
 * */
fun main3() {
    //类型后面加?表示可为空
    var age: String? = null
    //抛出空指针异常
    val ages = age!!.toInt()
    //不做处理返回 null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1
}

fun nullTest(): Int? {
    return null
}

fun main(args: Array<String>) {
    val x = nullTest()
    val y = nullTest()
    if (x != null && y != null) //must
        println(x + y)
}

/**
 * 类型检测及自动类型转换
 * 我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)
 * */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }

    //在这里还有一种方法，与Java中instanceof不同，使用!is
    // if (obj !is String){
    //   // XXX
    // }

    // 这里的obj仍然是Any类型的引用
    return null
}

fun getStringLength1(obj: Any): Int? {
    if (obj !is String)
        return null
    // 在这个分支中, `obj` 的类型会被自动转换为 `String`
    return obj.length
}

fun getStringLength2(obj: Any): Int? {
    // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
    if (obj is String && obj.length > 0)
        return obj.length
    return null
}

/**
 *区间
 *
 * 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
 * 区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。
 * 以下是使用区间的一些示例
 * */
fun main4() {
    for (i in 1..10) print(i) // 输出“1234”    1 <= i && i <= 10
    for (i in 10..1) print(i) // 什么都不输出

    // 使用 step 指定步长
    for (i in 1..4 step 2) print(i) // 输出“13”
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”

    // 使用 until 函数排除结束元素
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        println(i)
    }
}