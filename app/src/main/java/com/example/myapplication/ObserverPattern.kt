package com.example.myapplication

class ObserverPattern {
    val newsPublisher = NewsPublisher()
    init {
        newsPublisher.add(PeopleSubscriber(false))
        newsPublisher.add(PeopleSubscriber(true))
        newsPublisher.add(PeopleSubscriber(false))
    }
    fun publish(){
        newsPublisher.update("고급뉴우우우스", onlyPayed = true)
        newsPublisher.update("일반뉴우우우스", onlyPayed = false)
    }

}

// 발행 인터페이스를 정의한다.
interface Publisher {
    fun update(SubscribeStatus: String, onlyPayed:Boolean): Boolean
    fun add(subscriber: Subscriber): Boolean
    fun delete(subscriber: Subscriber): Boolean

}

class NewsPublisher : Publisher {

    private val observerList = mutableListOf<Subscriber>()

    override fun update(newsText: String, onlyPayed:Boolean): Boolean {
        observerList.forEach { it.onUpdate(newsText, onlyPayed) }
        return true
    }

    // 구독자를 추가한다
    override fun add(subscriber: Subscriber) = observerList.add(subscriber)

    // 구독자를 제거한다.
    override fun delete(subscriber: Subscriber) = observerList.remove(subscriber)
}



interface Subscriber {
    fun onUpdate(subscribeStatus: String, onlyPayed:Boolean): Boolean
}

class PeopleSubscriber(private val isPayedUser:Boolean = false) : Subscriber {

    override fun onUpdate(newsText: String, onlyPayed:Boolean): Boolean {
        if (onlyPayed == true && onlyPayed == isPayedUser) {
            println("프리미엄 뉴스:  $newsText")
            return true
        }
        if (onlyPayed != true) println("새로운 뉴스:  $newsText")
        return false
    }
}