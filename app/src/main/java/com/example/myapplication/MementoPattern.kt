package com.example.myapplication

class MementoPattern {
}


class Originator {
    private var state:String = ""
    fun setState(state: String?) {
        this.state = state!!
    }

    fun getState(): String? {
        return state
    }

    fun saveStateToMemento(): Memento? {
        return Memento(state)
    }

    fun getStateFromMemento(Memento: Memento) {
        state = Memento.getState()!!
    }
}

class Memento(private var stat: String?) {
    fun getState():String? {
        return stat
    }
}

class Caretaker {

    private val mementoList: MutableList<Memento> = ArrayList()

    fun add(state: Memento) {
        mementoList.add(state)
    }

    fun get(index: Int): Memento? {
        return mementoList[index]
    }

    fun countHistory() : Int {
        return mementoList.size
    }

}