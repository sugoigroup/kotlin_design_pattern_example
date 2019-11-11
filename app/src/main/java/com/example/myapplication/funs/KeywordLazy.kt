package com.example.myapplication.funs

/**
 * lazy()는 람다를 파라미터로 받고 Lazy<T> 인스턴스를 리턴하는 함수이다.
 * Lazy는 lazy 프로퍼티를 구현하기 위한 위임 객체이다. 처음 get() 을 호출하면
 * lazy()에 전달한 람다를 실행하고 그 결과를 저장하며 이후 get() 호출에 대해선
 * 저장한 결과를 리턴한다.
 */
class KeywordLazy {
    val lazyValue: String by lazy {
        "Hello"
    }
    val lazyValue2: MyLazy by lazy {
        MyLazy()
    }
}


class MyLazy() {
    fun pp(p: String): String {
        return p + "<--pp";
    }
}