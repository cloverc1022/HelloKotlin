@file:JvmName("StringFunctions")

package com.mmc.strings

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