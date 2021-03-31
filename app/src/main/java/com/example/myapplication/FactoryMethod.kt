package com.example.myapplication

import java.lang.RuntimeException

class FactoryMethod private constructor(){
    companion object {
        fun create(): FactoryMethod {
            return FactoryMethod()
        }
    }
    fun makeCar(maker: String) : Car {
        return when(maker) {
            "bmw" -> Bmw()
            "audi" -> Audi()
            else  -> throw RuntimeException("그런차 없어!")
        }
    }
}

class Bmw : Car {
    override val name ="bmw"
}

class Audi : Car {
    override val name ="audi"
}

interface Car  {
    val name: String
}