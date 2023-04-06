package com.example.libkotlinmodule

class DataTypes {


}

fun main() {

    val one = 1 // Int
    val threeBillion = 3000000000 // Long
    val oneLong = 1L // Long
    val oneByte: Byte = 1

    val pi = 3.14 // Double
// val one: Double = 1 // Error: type mismatch
    val oneDouble = 1.0 // Double

    val e = 2.7182818284 // Double
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817

    fun printDouble(d: Double) { print(d) }

    val intValue = 1
    val doubleValue = 1.0
    val foatValue = 1.0f

    printDouble(doubleValue)

    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false

    val byteValue: Byte = 1
// val i: Int = b // ERROr
    val number: Int = byteValue.toInt()

    val intDevideInt = 5 / 2
    println(intDevideInt == 2)

    val longInt = 5L / 2
    println(longInt == 2L)

    val intDouble = 5 / 2.toDouble()
    println(intDouble == 2.5)


    val uByte: UByte = 1u
    val uShort: UShort = 1u
    val uLong: ULong = 1u

    val uIntValue = 42u
    val uLongValue = 0xFFFF_FFFF_FFFFu


    val myTrue: Boolean = true
    val myFalse: Boolean = false
    val boolNull: Boolean? = null

    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)


    val text = """
    for (c in "foo")
        print(c)
"""
    println(text)

    val text2 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """

    val text3 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()


    println(text2)
    println(text3)

    val value = 10
    println("i = $value")


    val array = Array(5) { i -> (i * i).toString() }
    array.forEach { println(it) }

    val intAray: IntArray = intArrayOf(1, 2, 3)
    intAray[0] = intAray[1] + intAray[2]


    val arr = IntArray(5)

    val arr1 = IntArray(5) { 42 }




    for (element in arr){
        print(element)
    }

    println()
    for (element in arr1){
        print(element)
    }
    println()



}