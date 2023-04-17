package build;

import java.util.Scanner;

public class Program6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("which shape you want to make ? 1. Circle 2. Rectangle");
        int choice = sc.nextInt();

        if(choice == 1){
            Circle circle = new Circle();
            circle.getData();
            System.out.println("Area is "+circle.calculateArea());
        }else if (choice == 2) {
            Rectangle rectangle = new Rectangle();
            rectangle.getData();
            System.out.println("area is "+rectangle.calculateArea());
        }else {
            System.out.println("invalid Input");
        }

//
    }
}

abstract class Shape {
     abstract void getData();

    abstract Double calculateArea();
}

class Circle extends Shape {

    Double radiusCircle = 0.0;
    @Override
    void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter radius");
        this.radiusCircle = sc.nextDouble();
    }

    @Override
    Double calculateArea() {
        return 3.14*radiusCircle*radiusCircle;
    }
}

class Rectangle extends Shape {

    Double length;
    Double breadth;

    @Override
    void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter length and breadth");
        this.length = sc.nextDouble();
        this.breadth = sc.nextDouble();
    }

    @Override
    Double calculateArea() {
        return length*breadth;
    }
}