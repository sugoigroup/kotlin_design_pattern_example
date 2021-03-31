package com.example.myapplication

class VisitorPattern {


}

class Room1 : Camera {
    override fun display() {
       println("1번방 카메라로 방보기")
    }


    override fun cleanCheck() {
        println("1번방 방청소확인")
    }

    override fun visit(visitor: Visitor) {
        visitor.visit(this)
    }

}
class Room2 : Camera {
    override fun display() {
        println("2번방 카메라로 방보기")
    }

    override fun cleanCheck() {
        println("2번방 카메라로 방보기")
    }

    override fun visit(visitor: Visitor) {
        visitor.visit(this)
    }

}

interface Camera {
    fun display()
    fun cleanCheck()

    fun visit(visitor:Visitor)
}

interface Visitor {
    fun visit(room1: Room1)
    fun visit(room2: Room2)
}

class Visitors(val visitorName:String) : Visitor {
    override fun visit(room1: Room1) {
        println("$visitorName 방확인 : ${room1.display()}")
        println("$visitorName 청소확인 : ${room1.cleanCheck()}")
    }

    override fun visit(room2: Room2) {
        println("$visitorName 방확인 : ${room2.cleanCheck()}")
    }

}