package com.example.libkotlinmodule

class NestedAndInnerClasses {
}

fun main() {

    var bag = object : Bag{
        override var value: Int = 5000
        override fun material() {
            println("material")
        }

        override fun price() {
            println("price")
        }


    }
    bag.material()

    var myObject = object {
        var name: String = "rajan"
        fun printName(){
            println(name)
        }
    }



}

interface  Bag{
     var value: Int
     fun material()
     fun price()
}

class Outer {
    private val bar: Int = 1
    inner class Nested {
        fun foo() = bar
    }
}



interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OutClass {
    class InnerClass
    interface InnerInterface
}