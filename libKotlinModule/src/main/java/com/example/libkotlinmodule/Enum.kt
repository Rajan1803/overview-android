package com.example.libkotlinmodule

class Enum {


}

fun main() {
    var direction = Direction.NOTRTH
    direction.printStr()
    direction.name
    println( direction.number1)

    var d = Direction.NOTRTH

    d= Direction.NOTRTH
//    d.number1 = 3
    println(direction.number1)
    println(d.number1)
    println(d===direction)

    for (i in Direction.values()){
        println(i)
    }
    println(Direction.valueOf("WEST"))
    println(Direction.NOTRTH.name)
    println(Direction.NOTRTH.ordinal)

}
enum class Direction(var number1: Int): DirectionFunctions{


    NOTRTH(1){
        override fun printStr() {
            println("str north")
        }




        override fun printValue(number: Int) {

        }

    },SOUTH(2){
        override fun printStr() {
            println("str south")

        }
        override fun printValue(number: Int) {

        }

    },WEST(3) {
        override fun printStr() {
            println("str west")
        }
        override fun printValue(number: Int) {

        }
    },EAST(4) {
        override fun printStr() {
            println("str EAst")
        }

        override fun printValue(number: Int) {

        }
    };


    init {
    }

    override var number: Int =  0

    var str: String = "r"
   abstract fun printStr()
    override fun printDirection() {

    }


}

interface DirectionFunctions{
    var number: Int
    fun printDirection()
    fun printValue(number: Int)
}

