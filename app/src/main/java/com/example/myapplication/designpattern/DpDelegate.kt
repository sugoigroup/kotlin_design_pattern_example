package com.example.myapplication.designpattern

import kotlin.reflect.KProperty

interface Base {
    fun print():Int;
}
interface Base2 {

    fun print2();
}
class DpDelegate(val x:Int) : Base,Base2{
    override fun print2() {


    }

    fun notPring() {

    }

    override fun print():Int {
        return x
    }
}

class Delirived(b:Base, c:Base2) : Base by b, Base2 by c




