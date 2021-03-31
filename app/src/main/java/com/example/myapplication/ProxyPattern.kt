package com.example.myapplication

class ProxyPattern(val proxy:IProxyService)  : IProxyService {

    override fun connectSite(): String {
        return proxy.connectSite()
    }
}

interface IProxyService {
    fun connectSite():String
}

class ProxyService : IProxyService {
    override fun connectSite():String {
        return "connected"
    }
}

