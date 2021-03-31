package com.example.myapplication

class StrategyPattern(val basePrice:Int) {
    fun getPrice(whos: Discount):Int {
        return basePrice - whos.discount()
    }
}

interface Discount {
    fun discount() : Int
}

class DiscChild : Discount{
    override fun discount(): Int {
        return - 1000;
    }
}

class DiscAdult : Discount{
    override fun discount(): Int {
        return 0;
    }
}