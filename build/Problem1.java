
//Java Program 1
//
//        Write a matrix program in java to calculate addition, substraction and multiplication
//
//        Rule : row and column count should be enter by user. after inputting matrix values you've to ask 1. Addition 2.Substraction 3. Multiplication
//
//        make sure to handle all type of validation

package build;

import java.util.Scanner;

public class Problem1 {

    public static boolean checkInt(String str){

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row, column, input;
        String inputRow,inputColumn;

        System.out.println("Enter No. of rows");
        inputRow = sc.next ();

        // check if element entered are numbers


        if(!Problem1.checkInt(inputRow)){
            System.out.println("invalid row input");
            return;
        }

        System.out.println("Enter No. of columns");
        inputColumn = sc.next();


        // check if element entered are numbers

        if(!Problem1.checkInt(inputColumn)){
            System.out.println("invalid column Input");
            return;
        }

        row= Integer.parseInt(inputRow);
        column = Integer.parseInt(inputColumn);
        if (row == 0 || column == 0){
            System.out.println("enter valid size");
            return;
        }




        int matrixOne[][] = new int[row][column];
        int matrixTwo[][] = new int[row][column];
        int res[][] = new int[row][column];

        System.out.println("Enter element of matrix 1");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String temp = sc.next();

                // check if element entered are numbers

                if(!Problem1.checkInt(temp)){
                    System.out.println("invalid input");
                    return;
                }
                matrixOne[i][j] = Integer.parseInt(temp);
            }
        }


        System.out.println("Enter element of matrix 2");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String temp = sc.next();

                // check if element entered are numbers

                if(!Problem1.checkInt(temp)){
                    System.out.println("invalid input");
                    return;
                }
                matrixTwo[i][j] = Integer.parseInt(temp);
            }
        }

        while (true) {

            System.out.println("Choose options:");
            System.out.println("1. Addition");
            System.out.println("2. Substraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exit");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    doAddition(matrixOne, matrixTwo);
                    break;
                case 2:
                    doSubstraction(matrixOne, matrixTwo);
                    break;
                case 3:
                    doMultiplication(matrixOne, matrixTwo);
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }

    }


    private static void doAddition(int[][] matrix1, int[][] matrix2) {
        int res[][] = new int[matrix1.length][matrix1[0].length];

        if (!(matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length)) {
            System.out.println("number of column and rows are not same");
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                res[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void doSubstraction(int[][] matrix1, int[][] matrix2) {
        int res[][] = new int[matrix1.length][matrix1.length];

        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            if (!(matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length)) {
                System.out.println("number of column and rows are not same");
            }
        }

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    res[i][j] = matrix1[i][j] - matrix2[i][j];
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }

    }

    private static void doMultiplication(int[][] matrix1, int[][] matrix2) {
        int res[][] = new int[matrix1.length][matrix1.length];

        if(matrix1[0].length != matrix2.length){
            System.out.println("cant perform matrix multiplication ");
            return;
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                res[i][j] = 0;

                for (int k = 0; k < matrix1[i].length; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

}
