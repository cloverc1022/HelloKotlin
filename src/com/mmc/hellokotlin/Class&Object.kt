package com.mmc.hellokotlin

import java.io.File

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
    val ma = Student("machao", 20, 100)
    ma.foo()
}


//数据类和委托类(data，by关键字)
class Client(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name = $name,postalCode = $postalCode)"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return other.name == name && other.postalCode == postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

//data数据类，自动重写toString(),equals(),hashCode()等方法
data class KClient(val name: String, val postalCode: Int)

class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()
    override val size: Int
        get() = innerList.size

    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
}

//by委托类关键字
class KDelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList

/**
 * object关键字
 * 1.对象声明
 * 2.伴生对象
 * 3.对象表达式（代替java匿名内部类）
 * */
//1.对象声明，单例
object FileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }
}
