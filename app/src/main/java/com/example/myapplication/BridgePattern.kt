package com.example.myapplication

class BridgePattern {

}


abstract class Icon(var color:Color) {
    abstract fun applyColor()
}

class Triangle(val c:Color) : Icon(c) {
    override fun applyColor() {
        color.applyColor()
    }

}

class Rectangle(val c:Color) : Icon(c) {
    override fun applyColor() {
        color.applyColor()
    }

}

interface Color {
    fun applyColor();
}

class GreenColor : Color {
    override fun applyColor() {
        println("푸른색")
    }
}

class RedColor : Color {
    override fun applyColor() {
        println("뻘건색")
    }
}
