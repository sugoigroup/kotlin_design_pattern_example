package com.example.myapplication.designpattern


///https://codechacha.com/ko/kotlin-object-vs-class/
//object DpSingleTone {
//    val cars = mutableListOf<Car>()
//
//    fun makeCar(horsePower:Int):Car {
//        val car = Car(10)
//        cars.add(car)
//        return car
//    }
//
//}

class Car(val horsePower: Int) {
   companion object Factory {
       val cars = mutableListOf<Car>()

       fun makeCar(horsePower: Int):Car {
           val car = Car(horsePower)
           cars.add(car)
           return car
       }

   }
}


