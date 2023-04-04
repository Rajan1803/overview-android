package build.problem5P2;

import build.Program5.FirstClass;

//Create a class with 2 variables a1 and a2 in package P1, define default constructor, parameterised constructor and toString method. 
//
//Now create one more class in package P2 with variable a3 and reuse previous class. Define the constructors and override tostring method too. 
//
//Now write program to initialize object and print values inside package P1

public class SecondClass extends FirstClass {

    private int a3;



    SecondClass(int a1,int a2,int a3){
        super(a1,a2);
        this.a3 = a3;
    }

    @Override
    public String toString() {

        return  this.a3+super.toString();
    }



}
