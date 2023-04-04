package build;

import java.util.Scanner;

public class program7 {

    public static void main(String[] args) {

        System.out.println("enter number");
        Scanner sc = new Scanner(System.in);
        String inputNumber = sc.next();

        // to check that user has entered number in input
        if (!(Problem1.checkInt(inputNumber))){
            System.out.println("please enter integer value");
            return;
        }
        int number = Integer.parseInt(inputNumber);


        if (number%2 != 0) {
            System.out.println("invalid Input");
            return;
        }


        for(int j=number; j>0; j = j-2) {
            for (int i = 0; i < j; i++) {
                System.out.print("+");
            }
            System.out.println();

        }
        System.out.println("X");

        for(int j = 0;j<number;j= j+2){
            for(int i =0 ;i <=j+1 ; i++){
                System.out.print("+");
            }
            System.out.println();
        }
    }

}
