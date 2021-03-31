package com.example.myapplication

class DecoratorPattern : Hambuger{
    override fun getBread() {
        println("빵 두개 준비!")
    }

}

interface Hambuger {
    fun getBread()
}

open class BuggerDecorator(protected var hambuger: Hambuger) : Hambuger {
    override fun getBread() {
        this.hambuger.getBread()
    }
}

open class MeetBuggerDecorator(bugger: Hambuger) : BuggerDecorator(bugger) {
    override fun getBread() {
        super.getBread();
        this.addMeet();
    }
    private fun addMeet() {
        println("고기패티 추가")
    }
}

open class EggBuggerDecorator(bugger: Hambuger) : MeetBuggerDecorator(bugger) {
    override fun getBread() {
        super.getBread();
        this.addEgg();
    }
    private fun addEgg() {
        println("계란후라이 추가")
    }
}