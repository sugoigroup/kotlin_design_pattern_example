package com.example.myapplication

class CommandPattern {
    val allParts = mutableListOf<ComputerParts>()
    fun start(parts: ComputerParts) {
        allParts.add(parts)
        parts.on()
    }

    fun stop(parts: ComputerParts) {
        parts.off()
    }

    fun powerOff() {
        allParts.forEach(ComputerParts::off)
    }

}


interface Command {
    fun execute()
}
interface ComputerParts {
    fun on()
    fun off()
}

class OnCommand(private val pcEtc: ComputerParts) : Command {
    override fun execute() {
        pcEtc.on()
    }
}

class Printer : ComputerParts {
    override fun on() = println("print 시작")
    override fun off()  =  println("print 끔")
}

class Monitor : ComputerParts {
    override fun on()  =  println("monitor 전원켬")
    override fun off()  =  println("monitor 끔")
}

class LedLight : ComputerParts {
    override fun on()  =   println("led 켬")
    override fun off()  =  println("led 끔")
}




