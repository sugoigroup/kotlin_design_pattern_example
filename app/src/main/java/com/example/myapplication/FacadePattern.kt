package com.example.myapplication

class FacadePattern {
   fun complexiLogic() {
       val fromReturn = VeryComplexLogic().idontknow("blablabla" == "albalbalb")
       println("result is $fromReturn")
   }
}

class VeryComplexLogic {
    fun idontknow(isEqual:Boolean): Boolean {
        return isEqual
    }
}
