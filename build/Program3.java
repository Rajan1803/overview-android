package build;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Program3 {



    public static void main(String[] args) {

        String str1 = "rajan";
        String str2 = "najar";

        char[] charString1 = str1.toCharArray();
        char[] charString2 = str2.toCharArray();

        Arrays.sort(charString1);
        Arrays.sort(charString2);


        System.out.println(charString2);
        System.out.println(charString1);
        str1 = new String(charString1);
        str2 = new String(charString2);
        System.out.println(str1.equals(str2));
        if(str1.equals(str2)){
            System.out.println("both have same character");
        }else{
            System.out.println("both have diffrent charactors");
        }


//
//        if(str1.length() != str2.length()) {
//            System.out.println("Not equal");
//            return;
//        }
//        for(int i=0;i<str1.length();i++){
//            if (str2.contains(""+str1.charAt(i)) && str1.contains(""+str2.charAt(i))){
//
//            }else {
//                System.out.println("not equal");
//
//                return;
//            }
//        }
//
//            System.out.println("equal");
//

    }

}
