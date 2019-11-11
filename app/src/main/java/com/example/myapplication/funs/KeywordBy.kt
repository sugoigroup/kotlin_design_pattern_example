package com.example.myapplication.funs

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * by 키워드는 클래스 또는 프로퍼티를 위임할 때 사용하는 키워드다.
 * Delegation pattern은 상속의 좋은 대안으로 증명되었는데 Kotlin에서는 위임 패턴을
 * 작성해야 하는 boilerplate code 없이 언어 자체에서 위임 패턴을 지원한다.
 */
class KeywordBy(var p2:String) {
    var p:String by MydelegatorBy()
}

class MydelegatorBy :
    ReadWriteProperty<KeywordBy, String> {
    override fun setValue(thisRef: KeywordBy, property: KProperty<*>, value: String) {
        (thisRef as KeywordBy).p2 = value
    }

    override fun getValue(thisRef: KeywordBy, property: KProperty<*>): String {
        return (thisRef as KeywordBy).p2 + ":converted"
    }

}
