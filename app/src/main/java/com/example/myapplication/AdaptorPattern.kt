package com.example.myapplication

class AdaptorPattern(private val usbConnect: ToTypeC) {
   fun runConnect() {
       usbConnect.connect()
   }
}

interface ToTypeC {
   fun connect()
}


class Usb2 : ToTypeC{
    override fun connect() {
        println("usb2 연결됬어유")
    }

}

class Usb1 : ToTypeC{
    override fun connect() {
        println("usb1 연결됬어유")
    }

}


class Thunderbird : ToTypeC{
    override fun connect() {
        println("썬더버드 연결됬어유")
    }

}
