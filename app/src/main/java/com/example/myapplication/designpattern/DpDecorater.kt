package com.example.myapplication.designpattern

class DpDecorater {

    fun makeCoffee():Beverage {
        var totalCost:Int = 0;
        return Express()
    }
}

interface Beverage {
    val description:String
    fun cost():Int
}

class Express:Beverage {
    override val description: String
        get() = "coffe"

    override fun cost(): Int {
        return 1000;
    }
}

class Milk(val beverage: Beverage):Beverage by beverage {
    override fun cost(): Int {
        return 100 + beverage.cost()
    }

}

class Sugar(val beverage: Beverage):Beverage by beverage {

}

class Cream(val beverage: Beverage):Beverage by beverage {

    override fun cost(): Int {
        return 400 + beverage.cost()
    }
}

