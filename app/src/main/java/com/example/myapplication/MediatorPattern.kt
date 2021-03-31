package com.example.myapplication

class MediatorPattern() {
    companion object {
        fun requestFromAirplane(airplane: Airplane) {
            airplane.requestLanding()
        }
        fun confirmLanded() {
            AirplaneMediator.isLanding = false
        }
    }

}

class Airplane(val name: String, var mediator: Mediator) : Commander {
    var state = FLY.WATING
    override fun requestLanding() {
        state = mediator.canLand()
    }
}

interface Commander {
    fun requestLanding()
}

interface Mediator {
    fun canLand(): FLY
    fun endLand()
}

class AirplaneMediator : Mediator {
    companion object {
        var isLanding:Boolean = false
    }
    override fun canLand(): FLY {
        if(!isLanding) {
            isLanding = true
            return FLY.LANDING
        }
        return FLY.FLYING
    }

    override fun endLand() {
        isLanding = false
    }

}

enum class FLY {
    FLYING,
    WATING,
    LANDING,
}
