package com.example.libkotlinmodule


class DataClasses {
}

fun main() {
    val day=5;
//1 monday
//2 tuesday
// 3 to 5 == otherday
// 5+ = more days
// else "no day

    when{
           day == 1-> println("monday")
           day == 2->println("tueday")
        day  in 3..5->println("otherday")
        day> 5   -> println("sunday")
        else -> println("no positive number")
    }

    var data = DataClass("rajan",22)
    data.fullName = "abcc"
    var data_two = DataClass("rajan",22)
    data.fullName = "ccdd"
    data.age = 23
    println(data == data_two)

    var copiedData = data.copy(age = 90)
    println(copiedData.age)

    var (name: String,age: Int) = data
    println(name+"   "+age)
    var pair = Pair<String,Int>("rajan",22)
  //var triple = Triple

    val firstObject = Customer("John", 1122)
    val secondObject = Customer("Patrick", 1245)
    println(firstObject == secondObject) // Output: true
    println(firstObject.equals(secondObject)) // Output: true

    println(firstObject.component1())
    println(firstObject.component2())

    var tripple = Triple<Int,Int,Int>(1,2,3)
    var (first, second, third) = tripple

    var car = Car()

}

 class Car {
    var name: String = ""
    var age: Int = 22
    var number: Int = 12345



}
data class DataClass(var name: String, var age: Int){
    var fullName: String = "RP";
}
data class Customer(var name: String, var id: Int)


class X(var x: String){
    constructor(x: String,y:String): this(x){

    }
    init {
        println("hello")
    }
    init {
        println("he;;l")
    }

    init {
        println("sb")
    }
}