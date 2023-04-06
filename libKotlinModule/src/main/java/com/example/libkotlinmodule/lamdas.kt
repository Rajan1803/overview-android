package com.example.libkotlinmodule

class lamdas {
}

fun main() {
    var isEven = {a: Int ->  a%2 == 0}
    println(isEven(8))
    println(isEven(9))
    perform({ println("hello rajan")})

    var concate: (String,String)-> String = String::plus

    var addInts: (Int,Int) -> Int = {f,s -> f+s}

    val addFloats = {f: Float,s:Float -> f+s}

//    val addDouble = fun Double.(dd:Double): Double = this + it


    val greet = { name: String -> println(name + " good morning") }


    doTask{ println(it+" hello") }
    println(addInts(4,5))
    println(addFloats(4.5F,7.5F))
//    println(3.3.addDouble(5.4))

    println(concate("hello","rajan"))
    var lambdaName: String = "rajan"
     lateinit var lambda: () -> Unit

    fun abcd(lam: () -> Unit){
        lambda = lam
    }
    abcd(lam = {
        println(lambdaName)
    })

//    println(lambdaName)
    lambdaName = "sagar"
    println(lambdaName)
    println(lambda())



}

fun doTask(printSTR: (String)-> Unit){
    printSTR("rajan");
}

fun perform(greet: () -> Unit){
    greet()
}

