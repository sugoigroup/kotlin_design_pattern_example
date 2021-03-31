package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/**
 * https://codechacha.com/ko/category/kotlin/
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //　옵서버 패턴
        ObserverPattern().publish()

        //　템플렛 패턴
        TemplatePattern().instruceCompany()

        //　비시터 패턴
        val room1 = Room1()
        val room2 = Room2()

        room1.visit(Visitors("책임운영자"))
        room2.visit(Visitors("경비운영자"))

        // 메멘토 패턴
        val originator = Originator() // 기념비에 새길 내용
        val careTaker = Caretaker() // 기념비 관리자

        // 기념비 #1 을 세우고 기념비 관리에 추가
        originator.let {
            it.setState("기념비 #1");
            it.saveStateToMemento()?.let { mt ->
                careTaker.add(mt)
            };
        }
        // 기념비 #2 을 세우고 기념비 관리에 추가
        originator.let {
            it.setState("기념비 #2");
            it.saveStateToMemento()?.let { mt ->
                careTaker.add(mt)
            };
        }

        var historyReverse:Int = careTaker.countHistory()
        careTaker.get(--historyReverse)?.let { originator.getStateFromMemento(it) };
        println("이전에 세워진 기념비: " + originator.getState());

        careTaker.get(--historyReverse)?.let { originator.getStateFromMemento(it) };
        println("이전에 세워진 기념비: " + originator.getState());


        // 중재자 패턴
        val mediator1 = AirplaneMediator()

        val airplane717 = Airplane("b717", mediator1)
        airplane717.state = FLY.FLYING

        val airplane718 = Airplane("b718", mediator1)
        airplane718.state = FLY.FLYING

        val airplane719 = Airplane("b719", mediator1)
        airplane719.state = FLY.FLYING

        MediatorPattern.requestFromAirplane(airplane717)
        MediatorPattern.requestFromAirplane(airplane718)
        MediatorPattern.requestFromAirplane(airplane719)

        println("b717 ${airplane717.state}")
        println("b718 ${airplane718.state}")
        println("b719 ${airplane719.state}")

        MediatorPattern.confirmLanded()

        MediatorPattern.requestFromAirplane(airplane719)
        MediatorPattern.requestFromAirplane(airplane718)

        println("b719 ${airplane719.state}")
        println("b718 ${airplane718.state}")





        // 책임연쇄 패턴

        val chainOfResponsibilityPattern = ChainOfResponsibilityPattern(2600)
        chainOfResponsibilityPattern.payMe()

        val commandPattern = CommandPattern();
        commandPattern.start(Printer())
        commandPattern.start(Monitor())
        commandPattern.start(LedLight())

        commandPattern.powerOff()

        // 상태 패턴

        var statePattern = StatePattern()
        statePattern.currentLife()

        statePattern.nextLife()
        statePattern.nextLife()
        statePattern.currentLife()



        // 전략 패턴

        val StrategyPattern = StrategyPattern(1500)
        println("어린이는 ${StrategyPattern.getPrice(DiscChild())}")
        println("어른은 ${StrategyPattern.getPrice(DiscAdult())}")


        // 프록시 패턴

        val proxyPattern = ProxyPattern(ProxyService())
        proxyPattern.connectSite()


        // 경량화 패턴

        val flyweightPattern = FlyweightPattern()
        val enermy = flyweightPattern.getOrNewEnermy("고블린")
        enermy.attack()

        val enermy2 = flyweightPattern.getOrNewEnermy("악마")
        enermy2.attack()

        val enermyReuse = flyweightPattern.getOrNewEnermy("고블린")
        enermyReuse.attack()

        FlyweightPattern().printAll()

        // 표면화 패턴

        FacadePattern().complexiLogic()

        val folders = CompositePattern("/")
        folders.add(File("first.txt"))
        folders.add(File("second.txt"))

        val subfolders = Folder("/mysecret")
        subfolders.addComponent(File("secret1.txt"))
        subfolders.addComponent(File("secret1.txt"))

        folders.add(subfolders)
        folders.display()

        // 아답타 패턴

        var usbAdaptor = AdaptorPattern(Usb1())
        usbAdaptor.runConnect()

        usbAdaptor = AdaptorPattern(Usb2())
        usbAdaptor.runConnect()

        usbAdaptor = AdaptorPattern(Thunderbird())
        usbAdaptor.runConnect()


        // 추상팩토리 패턴

        val iconRed = Triangle(RedColor())
        iconRed.applyColor()


        val iconGreen = Rectangle(RedColor())
        iconGreen.color = GreenColor()
        iconGreen.applyColor()


        var orderProduct = AbstractFactoryMethod(CarProduct())
        println(orderProduct.spec())
        //이번 상품은 파워:200 MP, 바퀴:4WP, 날개:날개없음

        orderProduct = AbstractFactoryMethod(AirplaneProduct())
        println(orderProduct.spec())
        //이번 상품은 파워:3000 MP, 바퀴:3WP, 날개:날개두짝


        // 팩토리 패턴

        val factory = FactoryMethod.create()
        var bmw = factory.makeCar("bmw")
        var audi = factory.makeCar("audi")

        val eggBuger = EggBuggerDecorator(DecoratorPattern())
        println("달걀추가된 버거입니다. : ${eggBuger.getBread()}")

        val meetBuger = MeetBuggerDecorator(DecoratorPattern())
        println("미트 버거입니다. : ${meetBuger.getBread()}")


        val factory2 = FactoryMethod.create()

        MySingelton.repositry(true); // init 내용 출력
        MySingelton.repositry(true);
        MySingelton.repositry(true);

        val americano = BuilderPattern("java coffee")
        println("coffee type : ${americano.coffee}")

        val creamCoffee = BuilderPattern("cream coffee", cream = 3)
        println("coffee type : ${creamCoffee.coffee}, suger : ${creamCoffee.sugar}, cream: ${creamCoffee.cream}")

        val mixCoffee = BuilderPattern("mix coffee", sugar = 2, cream = 2)
        println("coffee type : ${mixCoffee.coffee}, suger : ${mixCoffee.sugar}, cream: ${mixCoffee.cream}")
    }
}


object MySingelton {
    init {
        println("init은 MySingletone이 처음 호출될때만 실행됨")
        //init 안에 디비접속정보등을 초기화 하는 로직을 넣는다.
    }
    fun repositry(isDev: Boolean): String {
        return if (isDev) "MyLocalDb" else "MyRemoteDb"
    }
}