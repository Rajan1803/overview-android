package com.example.libkotlinmodule

//import com.sun.tools.javac.jvm.Gen


//Complete this program in kotlin
//Create a class which holds following kinds of information
//Unique id
//Name
//Gender = Male/Female/Other , when calling method
//Date of birth
//Active Or not
//Album list where album has id and url
//Languages Known = it should comma separated value
//Note: use most appropriate class, data type, modifier, naming convention..
//Perform following operation
//- Create object and print gender like I’m male , I’m female..
//- print a month and day of birthdate
//- Create list of users
//- find users who knows English language and print those
//- find active users and print those
//- find a users who’s birthdate come after 2010
class Task2 {
}

fun main() {
    var user1 = Human(1,"rajan",Gender.MALE, Date(14,11,2001),true,"hindi","gujarati","english")
    user1.albumArray.add(Album(1,"abc"))
    user1.albumArray.add(Album(2,"bcd"))


    var user2 = Human(2,"sagar",Gender.MALE, Date(7,8,2002),true,"hindi","gujarati","english")
    user2.albumArray.add(Album(11,"xyz"))
    user2.albumArray.add(Album(22,"pqr"))


    var user3 = Human(3,"priyanshu",Gender.MALE, Date(15,6,2015),true,"hindi","gujarati","english")
    user3.albumArray.add(Album(111,"vwx"))
    user3.albumArray.add(Album(222,"hij"))
    user1.printGender()
    user1.printDayMonth()

    var userList = ArrayList<Human>()
    userList.add(user1)
    userList.add(user2)
    userList.add(user3)




    for(user in userList){
        if (user.isActive){
            println(user.name+" is active")
        }
    }

    for(user in userList){
       // println(1)
        if (user.languageKnown.contains("english")){
            println(user.name+ " knows English Language")

        }
    }

    for(user in userList){
        if (user.dateOfBirth.year>2010){
            println(user.name+ " born after 2010")
        }
    }
}

enum class Gender(string: String){
    MALE("i am male"),FEMALE("i am female"),OTHER("other")
}
data class Date(val day: Int,val month: Int,val year: Int)

data class Album(val id: Int,val url: String)
class Human(var uniqueId: Int,var name: String,var gender: Gender,var dateOfBirth: Date,var isActive: Boolean,vararg val languageKnown: String) {


    var albumArray = ArrayList<Album>()


    fun printGender(){
       "i'm ${gender.name}"
    }

    fun printDayMonth(){
        println("day: "+dateOfBirth.day+ " month: "+dateOfBirth.month)
    }




}