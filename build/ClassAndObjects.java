package build;

public class ClassAndObjects {



    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.description());

//        Student st = (Student)student.clone();
        Student st = student;
        st.age = 22;
        System.out.println(student.age);

        People people = new Student();
        System.out.println(people.description());
//        people = new Teacher();

        Vehicle bike = new Bike();
        System.out.println( bike instanceof  Bike);
        System.out.println(bike.getSpeed());

        Animals animals = new Lion();
        System.out.println(animals.eat() + animals.sleep() + animals.walk());

        System.out.println(10>20 ? "rajan" : "sagar");

    }
}
class Student extends People {
    String name ;
    int age;

    String description() {
        return "age: is "+age+" and name is "+name;
    }
}

class Teacher extends People {
    String name;
    int age;

    String teacherDescription() {
        return "age is: "+age+" and name is "+name;
    }

}

class People {

    String description() {
        return "rajan";
    }
}

abstract class  Vehicle {
    int speed = 100;
    abstract int getSpeed();
}

class Bike extends  Vehicle {


    @Override
    int getSpeed() {
       return this.speed;
    }
}

interface Animals {
    String eat();
    String walk();
    String sleep();
}

 abstract class AnimalSleep implements Animals{

    @Override
    public String sleep() {
            return "i am sleeping";
    }
}

class Lion extends AnimalSleep {

    @Override
    public String eat() {
        return "i ma eating";
    }

    @Override
    public String walk() {
        return "i am walking";
    }
}


