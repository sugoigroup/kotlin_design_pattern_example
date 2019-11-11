package com.example.myapplication.designpattern

class DpCommand {
    fun orderBurger():String? {

        var order = client().createOrder()
        order.takeOrder(Chefommand(Chef()))
        return order.orderUp()
    }
}

class client {
    fun createOrder() = Order();
}

class Order {
    var waitress:Command? = null

    fun takeOrder(command:Command) {
        this.waitress = command
    }

    fun orderUp():String? {
        return waitress?.execute()
    }
}

interface Command {
    fun execute():String
}

class Chef {
    fun makeBuger():String {
        return "burder"
    }
}

class Chefommand (val chef:Chef):Command {
    override fun execute():String {
        return chef.makeBuger()
    }

}