package com.example.myapplication

import java.lang.RuntimeException

class AbstractFactoryMethod (val vehicleFactory: VehicleFactory){
    fun spec() : String {
        val engine = vehicleFactory.getEngines();
        val wheels = vehicleFactory.getWheels();
        val wings = vehicleFactory.getFly();
        return "이번 상품은 파워:${engine.getPower()}, 바퀴:${wheels.getCount()}, 날개:${wings.getWing()}"
    }
}

// 추상팩토리 공장 인터페이스
interface VehicleFactory  {
    fun getEngines(): EngineFactory
    fun getWheels(): WheelFactory
    fun getFly(): WingFactory
}

// 자동차 주문서
class CarProduct : VehicleFactory {
    override fun getEngines() = CarPower()
    override fun getWheels() = CarWheel()
    override fun getFly() = CarWing()

}

// 비행기 주문서
class AirplaneProduct : VehicleFactory {
    override fun getEngines() = AirPlanePower()
    override fun getWheels() = AirPlaneWheel()
    override fun getFly() = AirPlaneWing()

}

// 엔진사양 추상화
interface EngineFactory  {
    fun getPower(): String
}
//자동차 엔진 구체화
class CarPower: EngineFactory  {
    override fun getPower() = "200 MP"
}
//비행기 엔진 구체화
class AirPlanePower: EngineFactory  {
    override fun getPower() = "3000 MP"
}

// 바퀴 사양 추상화
interface WheelFactory  {
    fun getCount(): String
}
//자동차 바퀴 구체화
class CarWheel: WheelFactory  {
    override fun getCount() = "4WP"
}
//비행기 바퀴 구체화
class AirPlaneWheel: WheelFactory  {
    override fun getCount() = "3WP"
}

// 날개 사양 추상화
interface WingFactory  {
    fun getWing(): String
}
//자동차 날개 구체화
class CarWing: WingFactory  {
    override fun getWing() = "날개없음"
}
//비행기 날개 구체화
class AirPlaneWing: WingFactory  {
    override fun getWing() = "날개두짝"
}



