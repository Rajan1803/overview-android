package com.example.libkotlinmodule

class Interface {
}
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}
fun interface isEven{
    fun isEven(number: Int)
}
fun main() {
    var bike: Bike = Bike(2)
    println(bike.numberOfWheels)
    println(bike.repair())
    println(bike.run())

    var c = C()
    c.printHello()
    c.printMessege()

    var accept = IntPredicate { it % 2 == 0 }
//    var isEven =
//    var speed: Int = Horse { 252 }
//    println(speed)

    var speed2 = object: Horse {
        override fun run(): Int {
            println("horse is runing")
            return 333
        }
    }

    println(speed2.run())
    speed2.sleep()
}
class Bike(wheels: Int) : Vehicles {
//    override var _company: String = "rajan"

    override var numberOfWheels: Int = wheels

//        get() = field
//        set(value) {
//            field = value
//        }

    init {
        this.numberOfWheels = wheels

    }
    override fun run() {
        println("run bike")
    }

    override fun repair() {
        println("bike Repair")
    }

}

interface Vehicles {


//        var company: String
//    get() { return _company }
//    set(value) {
//        _company = value
//    }
    var numberOfWheels:Int
    fun run()
    fun repair(){
        println("vehicle repair")
    }
}

interface A {
    fun printHello(){
        println("hello from A")
    }

    fun printMessege()
}

interface B {
    fun printHello(){
        println("hello from B")
    }

    fun printMessege(){
        println("messege from B")
    }
}

class C: A,B{
    override fun printHello() {
        super<B>.printHello()
        super<A>.printHello()
    }



    override fun printMessege() {
        super.printMessege()
    }


}

fun interface Horse{
    fun run(): Int

    fun sleep(){
        println("horse is sleeping")
    }
}

