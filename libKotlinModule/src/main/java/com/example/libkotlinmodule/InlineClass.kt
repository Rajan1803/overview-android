package com.example.libkotlinmodule

class InlineClass {


}


fun main() {
    var abc: ABC = ABC(3)

    var bc = ABC(4)
    println(abc)

    println(bc)

    abc.abd()
}

@JvmInline
value class ABC(val number: Int){

    val name: String
        get() = ""
    fun abd(){

    }
}