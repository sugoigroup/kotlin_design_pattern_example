package com.example.myapplication

import com.example.myapplication.designpattern.Car
import com.example.myapplication.designpattern.Delirived
import com.example.myapplication.designpattern.DpDelegate
import com.example.myapplication.designpattern.DpStragy
import org.junit.Test

import org.junit.Assert.*
import com.example.myapplication.funs.KeywordBy
import com.example.myapplication.funs.MydelegatorBy

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTestDesignPattern {

    @Test
    fun test_singleTone() {
        val car = Car.makeCar(150)
        assertEquals(150, car.horsePower)
        assertEquals(1, Car.cars.size)
    }

    @Test
    fun test_delegate() {
        val b = DpDelegate(150)
        assertEquals(150, Delirived(b, b).print())


    }

    @Test
    fun test_stragy() {
        val b = DpStragy()
        assertEquals("I am Flay", b.makeDuck(DpStragy.makeWhiteDuck()).fly())
        assertEquals("I Cant Flay", b.makeDuck(DpStragy.makeRubberDuck()).fly())


    }
}
