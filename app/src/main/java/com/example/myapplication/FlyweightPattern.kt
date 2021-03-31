package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi

class FlyweightPattern {
    fun getOrNewEnermy(name:String):Enermy {
        return EnermyFactory.getEnermy(name)
    }
    fun printAll() = EnermyFactory.allPrint()
}

class Enermy(val name: String) {
    fun attack() {
        println("$name 공격!")
    }
}

class EnermyFactory {
    companion object {
        val enermies = mutableMapOf<String, Enermy>()
        fun getEnermy(name: String) = enermies.computeIfAbsent(name) {
            Enermy(name)
        }
        fun allPrint() {
            enermies.forEach({
                println(it.key)
            })
        }
    }
}