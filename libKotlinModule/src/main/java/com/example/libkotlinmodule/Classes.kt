package com.example.libkotlinmodule

class Classes {


}


open class Fan(name: String,age: Int) {
    var name: String
    var age: Int

    init {
        this.name = name
        this.age = age
        println("init called Fan")
    }
}

class Tubelight(company: String): Fan(company,22) {
    var company: String = company

    init {

       // this.company = company;
        println(company)
        println("iniit called tubelight")
    }

    constructor(company: String,value: Int): this(company){
        println("secondory constructor tubelight")
    }

}


fun main(){
    println("hello")
    var student: Student = Student()
    println(student.name)

    var teacher: Teacher = Teacher("rajan",22)
    println(teacher.age)
    println(teacher.name)

    var tubelight: Tubelight = Tubelight("rajan",22)

    var derivedVar = DerivedClass("rajan")

    derivedVar.printName()
    var baseVar = derivedVar as Base
    derivedVar.printName()

}

class Student constructor(val name:String= "rajan"){
    //var name:String = name

}

open class Teacher(open var name: String){

    var age: Int = 0
    constructor(name: String,age: Int) : this(name) {
        this.age = age
    }

    open fun printName(){
        println("rajan")
    }
}

class Derived(override var name: String): Teacher("rajan"){

}

abstract class Person: Teacher {

    constructor(): super("rajan") {

    }

    abstract override fun printName()
}

open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

open class Rectangle1 {
    open fun draw() { /* ... */ }
}

interface Polygon {
    fun draw() { /* ... */ } // interface members are 'open' by default
}

class Square() : Rectangle1(), Polygon {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle1>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}

open class Base(var name: String, var age: Int) {

    open fun printName(){
        print("base")
        println(name)
    }

    init {
        println("init Base")
    }
}

class DerivedClass(var dName: String): Base(dName,22){


     fun printMyName() {
        println("override")
        println(name)
        println(dName)
         super.printName()
    }
    constructor(dname: String,age: Int) : this(dname) {

    }
    init {
        println("inint derivedClass")
    }
}

open class Vehicle {
   var wheels: Int
   constructor(wheels: Int){
       this.wheels = wheels
   }
}
class bike: Vehicle {
    var company: String
    constructor(company: String,wheels: Int): super(wheels) {
        this.company = company

    }

}