package com.example.libkotlinmodule
//
//class FirstClass {
//
//}

fun main(arg: Array<String>) {




    println(arg.contentToString())

    println(add(2,5))
    println(substract(5,3))
    printName("rajan")

    println("name: $name")
    changeName()
    println(name)

    var secondClass: SecondClass = SecondClass();
    println(secondClass.a)
    var thirdClass: ThirdClass = ThirdClass("rajan",22);
    println(thirdClass.name)
    println(thirdClass.age)

    var array = listOf<Int>(2,3,4,5)
    for (element in array){
        println("$element")
    }

    for(index in array.indices){
        println("$index value is ${array[index]}")
    }

    var index = 0
    while (index< array.size){
        println("at $index value is ${array[index]}")
        index++
    }

    //ranges

    for(i in 50 downTo 0 step 5){
        println(i)
    }

    println((1 in 1..5))

    when (5){
        in 1..3 -> println("1 to 3")
//        is Int -> println("Int")
        5 -> println("its 5")
    }

    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 127
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false


}

fun add(a: Int,b: Int): Int{
    return a+b;
}

fun substract(a: Int, b: Int) = a-b;

fun printName(name: String): Unit{
    println("my name is $name")
}

//val name = "rajan"
//name = "sagar"
var name = "rajan"

fun changeName(){
    name = "sagar"
}

class SecondClass() : ThirdClass("name", 2) {
    var a: Int = 0
    var b: String = ""
}
open class ThirdClass(name: String,age: Int) {
    var name: String = name;
    var age: Int = age
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf2(a: Int,b: Int): Int = if (a>b) a else b

