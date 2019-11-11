package com.example.myapplication.designpattern

//https://proandroiddev.com/kotlin-design-patterns-8e152540ee2c
//https://dev.to/lovis/gang-of-four-patterns-in-kotlin
//https://chercher.tech/kotlin/strategy-design-pattern-kotlin
//https://medium.com/@ahmedrizwan/kotlin-design-patterns-the-strategy-724c1ab632f6
//https://dev.to/lovis/gang-of-four-patterns-in-kotlin---slight-return
//https://qiita.com/kaleidot725/items/78ad17691bfb3c33f87d


//https://github.com/lmller/gof-in-kotlin
//https://github.com/emedinaa/kotlin-patterns/blob/master/State.kt
//https://github.com/GustavoAxel/design-patterns-kotlin
//https://github.com/dbacinski/Design-Patterns-In-Kotlin
class DpStragy {
    fun makeDuck(duck:Duck):Duck {
        return duck
    }

    companion object {
        fun makeWhiteDuck(): Duck {
            return WhiteDuck(ImplFlay(), ImplQuark())
        }
        fun makeRubberDuck(): Duck {
            return RubberDuck(ImplFlayNot(), ImplQuark())
        }
    }
}

abstract  class Duck {
    abstract fun fly():String
    abstract fun quark():String
}


class WhiteDuck(val flable:IFlay, val quarkable:IQuark):Duck() {
    override fun fly():String {
        return flable.execute();
    }

    override fun quark():String {
        return quarkable.execute();
    }

}

class RubberDuck(val flable:IFlay, val quarkable:IQuark):Duck() {
    override fun fly():String {
        return flable.execute();
    }

    override fun quark():String {
        return quarkable.execute();
    }

}

interface IFlay {
    fun execute():String;
}

class ImplFlay : IFlay {
    override fun execute():String {
        return ("I am Flay")
    }
}

class ImplFlayNot : IFlay {
    override fun execute():String {
        return ("I Cant Flay")
    }
}

interface IQuark {
    fun execute():String;
}

class ImplQuark : IQuark {
    override fun execute():String {
        return ("I am Quark")
    }

}