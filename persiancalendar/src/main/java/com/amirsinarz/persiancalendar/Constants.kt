package com.amirsinarz.persiancalendar

internal object Constants {

    const val PERSIAN_COMMA: Char = '،'

    val FIRST_CHAR_OF_DAYS_OF_WEEK_NAME: Array<Char> = arrayOf(
        'ش', 'ی', 'د', 'س',
        'چ', 'پ', 'ج'
    )

    val PERSIAN_DIGITS: CharArray = charArrayOf(
        '۰', '۱', '۲', '۳', '۴', '۵', '۶',
        '۷', '۸', '۹'
    )

    val ENGLISH_DIGITS: CharArray = charArrayOf(
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    )

    val DAYS_OF_WEEK: Array<String> = arrayOf(
        "شنبه",
        "یکشنبه",
        "دوشنبه",
        "سه‌شنبه",
        "چهارشنبه",
        "پنج‌شنبه",
        "جمعه"
    )

    val JALALI_MONTH: Array<String> = arrayOf(
        "فروردین", "اردیبهشت",
        "خرداد", "تیر",
        "مرداد", "شهریور",
        "مهر", "آبان",
        "آذر", "دی",
        "بهمن", "اسفند"
    )
}