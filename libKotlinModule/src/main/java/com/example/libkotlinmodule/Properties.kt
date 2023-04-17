package com.example.libkotlinmodule

import java.lang.reflect.Array.get

class Properties {
}
const val URLEND = ".com"
val returnedValue = returnInt()

    fun returnInt(): Int{
        return 5
    }
fun main() {

    var ractangle = Ractangle(width = 4, height = 2)
//    println(ractangle.area)
//    ractangle.width = 50
//    println(ractangle.area)
//    println(ractangle.getHeight)
//    ractangle.setHeight = 500
//    println(ractangle.getHeight)
//      println(ractangle.area)
    ractangle.area = 11
    println(ractangle.area)
    println(ractangle.size)
    ractangle.size = "large"
    println(ractangle.size)

//    const

    var circle: Circle = Circle()

    circle.setUp()
    if (circle.checkInit()) {
        println(circle.ractangle)
    }



}
class Circle {
    lateinit var ractangle: Ractangle

    fun setUp() {
        var name: String

        ractangle = Ractangle(2, 3)

    }

    fun checkInit(): Boolean{

        return this::ractangle.isInitialized
    }

}

class Ractangle(private var height: Int,var width : Int){


    private var _size: String? = null
    var size: String?
    get() {
        if (_size==null) {
            _size = "small"
        }
        return _size
    }
    set(value) {
        _size = value
    }


    var area: Int = 0
        get(){
            println("getter called")
            return field
        }
        set(value) {
            println("setter called")
            field = value
        }

    init {
        this.area = height
    }




    val getHeight: Int
    get() = this.height

    var setHeight: Int
    get() = this.height*this.width
    set(value) {
        height = value
    }

}