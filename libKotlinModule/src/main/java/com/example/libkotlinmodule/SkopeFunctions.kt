package com.example.libkotlinmodule

class SkopeFunctions {
}

fun main() {
    var abc = 0
    var glass = Glass("abc",200).also { it.isGood = true
    it.quality = 90}

    println(glass.isGood)
    println(glass.quality)

    glass.apply { isGood = false
    quality = 20}
    glass.let { value -> println(value.toString() + "ejakliojfkld") }



    println(glass.let { 88 })
    println(glass.also { 5 })

    println(glass.isGood)
    println(glass.quality)

    with(glass){
        isGood = false
        quality = 88
        println("hello")

    }

    println(glass.isGood)
    println(glass.quality)

    println(glass.run {
        isGood = true
        quality = 99
        22
    })
    println(glass.isGood)
    println(glass.quality)



    var runVar =  run {
        var name: String  = "rjan"
        var age: Int = 22

         name+age
    }
    var name: String = "abc"

    println(runVar)
    println(name)



}

data class Glass(var company: String,var capacity: Int){
    var isGood: Boolean = false
    var quality: Int = 0
}