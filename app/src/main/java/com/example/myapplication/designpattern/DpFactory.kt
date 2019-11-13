package com.example.myapplication.designpattern

import java.lang.RuntimeException

class DpFactory {
    var i:Int =0

    fun createAnimal(animalType:String):Animal {
        return when(animalType.trim().toLowerCase()) {
            "cat" -> Cat(i++)
            "dog" -> Dog(i++)
            else -> throw RuntimeException("Error")
        }
    }
}

interface Animal {
    val id:Int
}

class Dog(override val id: Int):Animal

class Cat(override val id: Int):Animal