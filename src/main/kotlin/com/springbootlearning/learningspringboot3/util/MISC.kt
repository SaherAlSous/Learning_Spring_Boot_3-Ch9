package com.springbootlearning.learningspringboot3.util

import com.springbootlearning.learningspringboot3.models.Employee

object MISC {

    val DATABASE = mutableMapOf(
        "First" to Employee("First", "Spring"),
        "second" to Employee("second", "Spring"),
        "third" to Employee("third", "Spring"),
    )
}