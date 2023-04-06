package com.example.libkotlinmodule

class ControlFlow {




}

fun main() {
    val age = 220

    if (age>18) println("adult") else if (age>12) println("teenager") else println("child")

    var a =2
    var b = 5

    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    println(max)

    when(val ageValue = age){
       in 1..12 -> println("child $ageValue")
        in 13..18 -> println("teenager $ageValue")
        in 18..150 , in 200..250 -> println("adult $ageValue")
//        else ->{
//            println("invalid age")
//        }
    }



    var bit:Bit = Bit.ONE

    when (bit) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
        // 'else' is not required because all cases are covered
    }

    var arr = arrayListOf<Int>(2,3,4,5,5,6)

    for(element in arr){
        println(element)
    }

    for(index in arr.indices){
        println(index)
    }

    for ((index,value) in arr.withIndex()){
        println("index: $index and value: $value")
    }

    var count = 10
    while(count < 10){
        println(count)
        count++
    }

    count = 10
     do{
         println(count)
         count++
     }while (count<10)


     // exceptions

    // throw Exception("my exception")
     try {
         throwException()
     }catch (e: Exception){
        println(e)
     }finally {
         println("finally")
     }


    var tryValue: Int? = try {
        "5".toInt()
    }catch (e: Exception){
        null
    }

    println(tryValue)

    val nullValue = null // type is Nothing?
    var myValue:Int = nullValue ?: -1

   // var intValue = nullValue ?: throw KotlinNullPointerException()
    

    throwException()


}
enum class Bit {
    ZERO, ONE
}

fun throwException(): Nothing {
    throw Exception("throwException func")
}