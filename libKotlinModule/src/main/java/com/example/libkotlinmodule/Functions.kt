package com.example.libkotlinmodule


class Functions {

    companion object{

    }

}

fun main() {
    var array = intArrayOf(1,2,3)
    var sum = sum(1,2,*array,3, num1 = 33, num2 = 44)
    println()

    println(Functions tostring sum )


}



fun sum(vararg numbers: Int,num1: Int,num2: Int): Int{
    var sum: Int = 0


    numbers.forEach { sum += it}
    return sum
}

infix fun Functions.Companion.tostring(num: Int): String{
    return num.toString()
}