package com.example.libkotlinmodule

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Collections {


}
class SS(){
    var hight = 0
}
fun main(){
    println("hello")



//    var numberList: ArrayList<Int> = listOf(1,2,3,4)
    var numbersArrayList: ArrayList<SS> = arrayListOf<SS>(SS())

    var numbersSet = mutableSetOf<Int>(1,2,3,4,5)
    for (number in numbersSet.indices){
        println(number)
    }
//    hashSetOf<>()


    numbersSet.add(44)
    println(numbersSet.plus(7))

//    numbersSet.
    println(numbersSet.minus(2))

    for (number in numbersSet){
        println(number)
    }

    var map = hashMapOf<Int,String>(1 to "one",2 to "two")
    map[3] = "three"
//    map.put()
    val map1 = buildMap { // this is MutableMap<String, Int>, types of key and value are inferred from the `put()` calls below
        put("a", 1)
        put("b", 0)
        put("c", 4)
    }

    val linkedList = LinkedList<String>(listOf("one", "two", "three"))
    val presizedSet = HashSet<Int>(32)

    val numbers = listOf("one", "two", "three", "four")
    var asso = numbers.associateWith { it.length }
    println(asso["three"])

    val numbers1 = listOf("one", "two", "three", "four")
    for (number in numbers1){
        println(number)
    }
    val numbersIterator = numbers1.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.uppercase() })
    println(numbersMap.mapValues { it.value + it.key.length })


    val containers = listOf(
        listOf("one", "two", "three"),
        listOf("four", "five", "six"),
        listOf("seven", "eight")
    )
    println(containers.flatMap { it })

    val numbers2 = listOf("one", "two", "three", "four")

    println(numbers2)
    println(numbers2.joinToString())

    val listString = StringBuffer("The list of numbers: ")
    numbers2.joinTo(listString)
    println(listString)


    val lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }

    println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))
}