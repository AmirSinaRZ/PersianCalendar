package com.amirsinarz.persiancalendar.util

import com.amirsinarz.persiancalendar.Constants

internal fun Int.farsiDigits(): String {
    val number = this.toString()
    val output = StringBuilder()
    for (char in number) {
        val index = Constants.ENGLISH_DIGITS.indexOf(char)
        if (index != -1)
            output.append(Constants.PERSIAN_DIGITS[index])
        else
            output.append(char)
    }
    return output.toString()
}

internal fun String.farsiDigits(): String {
    val output = StringBuilder()
    for (char in this) {
        val index = Constants.ENGLISH_DIGITS.indexOf(char)
        if (index != -1)
            output.append(Constants.PERSIAN_DIGITS[index])
        else
            output.append(char)
    }
    return output.toString()
}

internal fun String.enDigits(): String {
    val output = StringBuilder()
    for (char in this) {
        val index = Constants.PERSIAN_DIGITS.indexOf(char)
        if (index != -1)
            output.append(Constants.ENGLISH_DIGITS[index])
        else
            output.append(char)
    }
    return output.toString()
}