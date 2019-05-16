@file:JvmName("StringFunctions")

package com.mmc.strings

/**
 *
 * 扩展方法，扩展属性
 *
 * 扩展函数不能被重写
 *
 * */

//扩展方法
@JvmOverloads
fun <T> joinToString(collection: Collection<T>, separator: String = ",", pre: String = "", post: String = ""): String {
    val result = StringBuilder(pre)
    for ((index, value) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(value)
    }
    result.append(post)
    return result.toString()
}

fun String.lastChar(): Char = get(length - 1)

@JvmOverloads
fun <T> Collection<T>.printToString(separator: String = ",", start: String = "", end: String = ""): String {
    val result = StringBuilder(start)
    for ((index, value) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(value)
    }
    result.append(end)
    return result.toString();
}

fun Collection<String>.printToStringString(separator: String = ",", start: String = "", end: String = "") =
    printToString(separator, start, end)

//扩展属性
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        setCharAt(length - 1, value)
    }

//中缀调用、解构声明
infix fun Any.to(other: Any) = Pair(this, other)

//局部函数及扩展
class Student(val id: Int, val name: String, val address: String)

//fun printInfo(student: Student) {
//    if (student.name.isEmpty())
//        throw IllegalArgumentException("can't print student ${student.id}:empty name")
//    if (student.address.isEmpty())
//        throw IllegalArgumentException("can't print student ${student.id}:empty address")
//    println("no.${student.id} name:${student.name} address:${student.address}")
//}

//提取局部函数避免代码重复
//fun printInfo(student: Student) {
//    fun isValid(value: String, name: String) {
//        if (value.isEmpty())
//            throw IllegalArgumentException("can't print student ${student.id}:empty $name")
//    }
//    isValid(student.name, "name")
//    isValid(student.address, "address")
//    println("no.${student.id} name:${student.name} address:${student.address}")
//}

//提取局部函数逻辑到扩展函数
fun Student.validBeforePrint() {
    fun isValid(value: String, name: String) {
        if (value.isEmpty())
            throw IllegalArgumentException("can't print student $id:empty $name")
    }
    isValid(name,"name")
    isValid(address,"address")
}
fun printInfo(student: Student) {
    student.validBeforePrint()
    println("no.${student.id} name:${student.name} address:${student.address}")
}