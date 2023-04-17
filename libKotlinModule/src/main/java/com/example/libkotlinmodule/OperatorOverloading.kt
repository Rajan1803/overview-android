package com.example.libkotlinmodule

class OperatorOverloading {
}

fun main() {

    var point = Point(2,5)
    println(-point)

//    var value = Value(5)
//    println(value.value)
//    value = value + 3

}

data class Point(val x: Int,val y:Int)
operator fun Point.unaryMinus() = Point(-x,-y)
//
//data class Value(var value: Int){
//    operator fun Value.plus(inc: Int): Int{
//        value+=inc
//        return value
//    }
//}