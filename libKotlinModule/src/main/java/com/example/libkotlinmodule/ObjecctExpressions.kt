package com.example.libkotlinmodule

class ObjecctExpressions {
}

fun main() {
    val helloWorld = object {
        val hello = "Hello"
        val world = "World"
        // object expressions extend Any, so `override` is required on `toString()`
        override fun toString() = "$hello $world"
    }

    println(helloWorld.hello)
    println(helloWorld)

    println(Singleton.name)
    Singleton.name = "sagar"
    println(Singleton.name)

    val temp = Wire
    temp.length
    temp.width

}

open class ClassOne(x: Int) {
    public open val y: Int = x
}

interface InterFaceOne {
    fun interFunction()
}

class ClassTwo{

      private fun getObject() = object {
        val str: String = "default"
          var age = 24
    }

    fun printStr(){
        getObject().str
    }


}

object Singleton {
    var name: String = "rajan"
}

class Wire{
    val company: String ="sony"
    companion object {
        val length: Int = 10
        val width: Int = 2
}
}