package com.example.myapplication

class StatePattern {
    var nowState:States = Born()
    fun nextLife() {
        nowState = nowState.nextState()
    }
    fun currentLife() = nowState.getState()
}

interface States {
    fun getState()
    fun nextState() : States
}

class Born : States {
    override fun getState() = println("태어남")
    override fun nextState(): States {
        return Infant()
    }

}

class Infant : States {
    override fun getState() = println("아기때")
    override fun nextState(): States {
        return Adult()
    }

}

class Adult : States {
    override fun getState() = println("성인")
    override fun nextState(): States {
        return Die()
    }

}
class Die : States {
    override fun getState() = println("죽음")
    override fun nextState(): States {
        return Born()
    }

}