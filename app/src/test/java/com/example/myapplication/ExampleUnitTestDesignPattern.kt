package com.example.myapplication

import com.example.myapplication.designpattern.*
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

    @Test
    fun test_decorater() {
        val b = DpDecorater().makeCoffee()
        assertEquals(1000, b.cost())

        val addMilk = Milk(b);
        assertEquals(1100, addMilk.cost())

        val addSugar = Sugar(addMilk);
        assertEquals(1100, addSugar.cost())

        val addCream = Cream(addSugar);
        assertEquals(1500, addCream.cost())


    }

    @Test
    fun test_dommand() {


        assertEquals("burder", DpCommand().orderBurger())


    }
}
