package com.example.myapplication

class ChainOfResponsibilityPattern(val wantPay:Int) {
    val banks = mutableListOf<PayMoney>()

    init {
        banks.add(PayMoney(wantPay, BankArea1()))
        banks.add(PayMoney(wantPay, BankArea2()))
        banks.add(PayMoney(wantPay, BankArea3()))
    }

    fun payMe() {
        banks.forEach {
            if (it.payProcess()) return
        }
    }
}

class PayMoney(val billMoney:Int = 0, var next:Process? = null) {
    fun payProcess():Boolean {
        if(next?.canBill(billMoney) == true) {
            next?.runBill(billMoney)
            return true
        }
        return false
    }
}

interface Process{
    fun canBill(amount: Int): Boolean
    fun runBill(amount: Int)
}

class BankArea1: Process {
    var remain = 1000
    override fun canBill(amount: Int): Boolean {
        remain = remain - amount
        return remain > 0
    }
    override fun runBill(amount: Int) {
        remain = remain - amount
        println("1번은행")
    }
}

class BankArea2: Process {
    var remain = 3000
    override fun canBill(amount: Int): Boolean {
        remain = remain - amount
        return remain > 0
    }
    override fun runBill(amount: Int) {
        remain = remain - amount
        println("2번은행")
    }

}

class BankArea3: Process {
    var remain = 5000
    override fun canBill(amount: Int): Boolean {
        remain = remain - amount
        return remain > 0
    }
    override fun runBill(amount: Int) {
        remain = remain - amount
        println("3번은행")
    }

}