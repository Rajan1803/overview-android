package com.example.libkotlinmodule

import java.lang.Exception

class Visibility {


}


fun main() {

    var tubelight: TubeLight = TubeLight()
    println(tubelight.power)


//    try {
        alwaysThrowException()
//    }catch (e: Exception){
//        println(e)
//    }
    println("hello")

    println(EmployeeData.company)


}

fun alwaysThrowException(): Nothing {
    throw IllegalArgumentException()

}
class EmployeeData(var empId: Int, var empName: String) {

    // fields which are common across class objects
    companion object OrgData {
        val company  = "CompanyA"
        val companyLocation = "New York"
    }
}

//Companion object fields can be accessed using

open class TubeLight {
    public var power: Int = 30


}

class SubTube: TubeLight() {


    fun printInfo(){
        super.power
    }
}

open class OuterClass{
    private var privateName: String = "rajan"
    protected var protectedName: String = "rajan"
    internal var internalName: String = "rajan"
    public var name: String = "rajan"

    var age: Int = 22

    protected class InnerClass {
        var innerName: String = "inner String"
    }



}

class DerivedOuter: OuterClass(){
    fun checkVisibolity(){
        super.protectedName
        super.internalName
        super.name

    }
}

class Monitor private constructor(screenSize: Int){

}