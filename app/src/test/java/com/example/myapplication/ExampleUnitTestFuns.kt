package com.example.myapplication

import com.example.myapplication.designpattern.Car
import com.example.myapplication.designpattern.Delirived
import com.example.myapplication.designpattern.DpDelegate
import org.junit.Test

import org.junit.Assert.*
import com.example.myapplication.funs.KeywordBy
import com.example.myapplication.funs.KeywordLazy
import com.example.myapplication.funs.MydelegatorBy

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTestFuns {

    @Test
    fun test_by() {

        val e: KeywordBy = KeywordBy("a")
        e.p = "gege"
        assertEquals("gege"+ ":converted", e.p )

    }

    @Test
    fun test_lazy() {
        val lazy = KeywordLazy()
        assertEquals("Hello", lazy.lazyValue)
        assertEquals("Hello" + "<--pp", lazy.lazyValue2.pp("Hello"))
    }
}
