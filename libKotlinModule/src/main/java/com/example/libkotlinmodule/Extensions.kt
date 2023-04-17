package com.example.libkotlinmodule

class Extensions {
}

fun main() {
    var basicFunctions = BasicFunctions()
    println(basicFunctions.addition(3,4))
    println(basicFunctions.substraction(6,2))

    fun printData(base: BaseCL){
        base.printName()
    }

    printData(DerivedCL())


    Example().printFunctionType()

    Companion.printMessege()
    Companion.printName()

    var mouse = Mouse()
    mouse.abc()
}

class Keybord {

    fun keybordFunction(){
        println("inside keybord")
    }
}


fun Keybord.printMessege(){


    println("messege from keybord")
    this.toString()

    keybordFunction()


}
class Mouse {
    var name = "rajan"
    fun printName(){
        println(name)
    }

    override fun toString(): String {
        println("mouse to string")
        return super.toString()
    }
    fun Keybord.printMessege(){


        println("messege from keybord")
        this.toString()
        this@Mouse.toString()
        keybordFunction()
        printName()

    }

    var keybord  = Keybord()
    fun abc(){
        keybord.printMessege()
    }

}

class Companion {


//    private var number = 0
    companion object {
    var number = 0
        fun printMessege(){
            println("messege printed")
            println(number)

        }
    }


}

fun Companion.Companion.printName(){
    println("rjn")
}

class BasicFunctions {
    fun addition(number: Int,number2: Int): Int{
        return number + number2
    }

}
fun BasicFunctions.substraction(number: Int,number2: Int): Int{
    return number-number2
}

open class BaseCL
class DerivedCL: BaseCL()
fun BaseCL.printName(){
    println("baseCL")
}
fun DerivedCL.printName(){
    println("derivedCL")
}
class Example {
    fun printFunctionType() { println("Class method") }
}

fun Example.printFunctionType() { println("Extension function") }
//
//
//
//class UserClass{
//    var name: String = ""
//}
//
//fun PersonClass?.changeToUser(){
//    if (this == null) return
//
//    var userclass = UserClass()
//    userclass.name = this.name
//    return
//}