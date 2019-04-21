package com.mmc.hellokotlin

/**
 * Kotlin 类和对象
 *
 * 类定义
 *Kotlin 类可以包含：构造函数和初始化代码块、函数、属性、内部类、对象声明
 *
 * Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后
 * 如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略
 * */
class Student constructor(name: String, age: Int, score: Int) {

    val name: String = name                //类型为 String 类型,默认实现 getter
        get() = field.toUpperCase()

    var age: Int = age                        //类型为 Int, 默认实现了 getter 和 setter
        get() = field
        set

    var grade: String? = null
        get() = field?.toUpperCase()
        set


    fun foo() {
        print("name is $name \n age is $age")
    }
}

//空类
class Empty

fun main(args: Array<String>) {
    val ma = Student("machao", 20,100)
    ma.foo()
}