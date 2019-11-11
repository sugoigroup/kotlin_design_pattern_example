package com.example.myapplication.designpattern

import kotlin.reflect.KProperty

// https://codechacha.com/ko/kotlin-deligation-using-by/
//https://namget.tistory.com/category/IT/개발스터디%20디자인패턴
//https://black-jin0427.tistory.com/193?category=795220

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

class Delirived(b:Base, c:Base2) : Base by b, Base2 by c {
    // print, print2 를 오버라이드 안해도 사용가능
}




