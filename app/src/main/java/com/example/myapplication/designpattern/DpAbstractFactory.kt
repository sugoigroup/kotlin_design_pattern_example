package com.example.myapplication.designpattern


//https://beomseok95.tistory.com/149 제너릭 제너릭


class DpAbstractFactory {

    val box = Box<Cat2, Cat2>()
    fun test() {
         box.put(Cat2())
    }

    fun <Cat2>testget() {
        box.get();
    }

    fun Cat2.mow() {
        print("mow")
    }
}

abstract class AbsFactory {

}




class Box<in T, out T2> {
    private var inside:T? = null
    private var inside2:T2? = null

    fun put(t:T) {
        inside = t

    }

    fun get():T2? = inside2
}

class Cat2

