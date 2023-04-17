package com.example.myapplication;

public class Task {
    public static void main(String[] args) {
        Person person = null ;
        Person person1 = new Person();
                person1.name = "rajan";

        Person person2 = new Person();
        person1.name = "rajan";
        System.out.printf(String.valueOf(person1 == person2));

        if (person != null) {
            System.out.println(person.name);
        }
    }
}
class Person{
    String name = "rajan";

}