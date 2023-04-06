package com.example.libkotlinmodule

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

//import com.example.libkotlinmodule.Companion.Companion.number

class Delegate {
}

interface BaseInterface{

    var num: Int
    fun print()
    fun printNum()
}

interface Vehicle1{
    fun print1()
}

interface Animal1{
    fun print2()
}

class Car1: Vehicle1{
    override fun print1() {
        println("car print1")
    }

}

class Monkey: Animal1{
    override fun print2() {
        println("monkey print2")
    }
}
class Worker(var car: Car1,var monkey: Monkey) : Vehicle1 by car,Animal1 by monkey{

}

class Name{
    var lastName: String by NameDelegate()
    fun printName(){
        lastName = "ln"
        println(lastName)
    }
}


class NameDelegate{


    var temp: String = ""
    operator fun getValue(thisRef: Name, property: KProperty<*>): String {
        return temp
    }
    operator fun setValue(thisRef: Name, property: KProperty<*>, value: String) {
        temp = value
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }


}





fun main() {
    var worker = Worker(Car1(),Monkey())
    worker.print1()
    worker.print2()

  var helper = Helper(11)
    var derivedClas = DerivedClas(helper)
    derivedClas.print()
    derivedClas.printNum()







    val list = mutableListOf("")

//    list.sortBy { it.name }

//    list.sortBy { it.length }

    var list3 = mutableListOf(list,list)
    list3.flatMap { it }

//    val list2 = list.map { it.length }
//    list2.toMutableList().add(33)
    list.removeAll { list.indexOf(it) %2 == 0 }


//    var value: String by NameDelegate()
//    value = "hgynm"
//    println(value)

    var name = Name()
    name.lastName = "hhhhhgggg"
    name.lastName
    println(name.lastName)


//    var password: String by PassDele()
//    password = "pass"
//    println(password)


//    var password1 = Password()
//    password1.password = "rajan"
//    println(password1)

    var lazy = Lazy()
    lazy.lazyVar

    var observe:String by Delegates.observable("str"){
        prep,old,new ->
        println("old value: $old and new value: $new")
    }

    var vatoable: String by Delegates.vetoable("ssttrr"){
        pro,old,new ->

        new != "null"
    }
    observe = "rajan"
    println(vatoable)


    var prop = DelegateProp()
    println(prop.name)
    println(prop.str)

    prop.name = "sagar"
    println(prop.name)
    println(prop.str)

    prop.str = "rrr"

    println(prop.name)
    println(prop.str)

    var mapDelegate = MapDelegate(mapOf("name" to "rajan","age" to 22))

    println("name ${mapDelegate.name} and age: ${mapDelegate.age}")

    var name3: String by StudentDelegate()


    val impiment: String = ""

//    var prop1: String by impiment

    var prop2: String by VarProp()

    println(prop2)
    prop2 = "aabb"
    println(prop2)


}


class VarProp {

    private var temp = ""
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
       return temp
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, s: String) {
        temp = s
    }




}
class StudentDelegate(){
    var temp: String = ""
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return temp
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {

        temp = value

    }

    var field =""
    
    
}
class MapDelegate(map: Map<String,Any?>){
    val name: String by map
    val age: Int by map
}

class DelegateProp{
    var name: String = "rajan"

    var str: String by StudentDelegate()::temp
}

class Lazy{
    val lazyVar: String by lazy {
        println("lazy called")
        "abbc"
    }
}

class Password {
    var password: String by PassDele()
}

class PassDele : ReadWriteProperty<Any?, String> {
    private var value = ""
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
       return value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, v: String) {
        TODO("Not yet implemented")
        value = v+"11"
    }

}


class Helper(number: Int): BaseInterface {

    override var num = number
    override fun print(){
        println(num)
    }

    override fun printNum(){
        println("num: "+num)
    }


}

class DerivedClas(base: BaseInterface): BaseInterface by base{


    override var num: Int = 0

}