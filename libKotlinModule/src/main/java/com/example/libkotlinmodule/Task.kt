package com.example.libkotlinmodule

class Task {
}

fun main() {
    var person: PersonClass? = PersonClass("rajan",22)

    println(person.convertToString())
}
class PersonClass(var name: String,var age: Int){

}



fun PersonClass?.convertToString(): String{
    if(this == null) return "null"
    return this.name
}

class UserClass(var name: String){

}

fun PersonClass?.getUser(): UserClass? {
    if(this == null) return null
    var user = UserClass(this.name);
    return user
}