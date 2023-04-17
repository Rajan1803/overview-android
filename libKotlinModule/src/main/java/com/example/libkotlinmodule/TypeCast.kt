package com.example.libkotlinmodule

import kotlin.reflect.typeOf

class TypeCast {
}

fun main() {


    var a = 10
    var obj:Any = 5

//    println(obj+1)

//    println("abc"+1)
//    when(obj){
//        is String -> println(obj+"string")
//        is Int -> println(obj+1)
//
//    }

    var nameString: Any = 234

    var number: Int? = nameString as? Int

    println(number)

    if (obj !is Int) return
    obj = "str"
    obj += 1
    println(obj+1)

    if (obj is String) {
        println(obj.length)
    }

    if (obj !is String) { // same as !(obj is String)
        print("Not a String")
    } else {
        print(obj.length)
    }

    demo(22)

    var value:Any = "rajan"

    if (value !is String) return

    print(value.length) // value is automatically cast to String


    // value is automatically cast to String on the right-hand side of `||`
    if (value !is String || value.length == 0) return

// value is automatically cast to String on the right side of `&&`
    if (value is String && value.length > 0) {
        print(value.length) // value is automatically cast to String
    }


    when (value) {
        is Int -> print(value + 1)
        is String -> print(value.length + 1)
        is IntArray -> print(value.sum())
    }

    var str:Any = 55

    // as will throw exception if fails
    // as? will give null if fails
    val x: String? = str as? String
    println("------------")
    println(x)

}

fun demo(x: Any) {
    if (x is String) {
        println(x.length) // x is automatically cast to String
    }else {
        println("not a string")
    }



}