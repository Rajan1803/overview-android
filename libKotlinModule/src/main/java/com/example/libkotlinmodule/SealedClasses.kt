package com.example.libkotlinmodule

import java.io.IOError

class SealedClasses {
}

fun main() {
//    var error = Errors()

    var state = NetworkError.Success(1)
    checkState(state)


}
fun checkState(state: NetworkError) {

    when(state){
        is NetworkError.Success -> println(state.data)
        is NetworkError.Fail -> println(state.e)
        is Errors -> println(state.throwErrors().message)

    }

}
open class abc{

}
sealed class NetworkError: abc() {

//    var name: String = "rajan"
//

    data class Success(var data: Int): NetworkError()


    class Fail(var e: Error): NetworkError()




}
class Errors : NetworkError() {
    fun throwErrors(): Error {
        return error("error here")
    }
}

