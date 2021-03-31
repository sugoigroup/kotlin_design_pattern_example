package com.example.myapplication

class TemplatePattern {
    fun instruceCompany() {
        val hrTeam = HrTeam()
        println("인사부의 하루: ")
        hrTeam.ourDaily()

        val devTeam = DevTram()
        println("개발부의 하루: ")
        devTeam.ourDaily()
    }

}
abstract class DailyRoutine {
    private fun commute() {
        print("hurry!hurry!hurry!")
    }
    abstract fun toWork()

    private fun eatLunch() {
        print("delicious!!!")
    }

    private fun goHome() {
        print("home!home!home!")
    }

    fun ourDaily() {
        print("${commute()} -> ${toWork()} -> ${eatLunch()} -> ${goHome()}")
    }

}

class HrTeam : DailyRoutine() {
    override fun toWork() {
        print("seek!seek!seek!")
    }

}

class DevTram : DailyRoutine() {
    override fun toWork() {
        print("coding!coding!coding!")
    }

}