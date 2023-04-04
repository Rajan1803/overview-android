package build;

import java.util.HashMap;

public class Program2 {

    // without using hashmap
    public static void main(String args[])
    {
        String str = "rajan";

        int array[] =new int[500];

        for(int i = 0;i<str.length();i++){
            array[str.charAt(i)] ++;
        }

        for(int i =0 ;i<500; i++){
            if (array[i]!=0){
                System.out.println((char)i +" at: "+array[i]);
            }
        }

//        HashMap <Character, Integer> charCount = new HashMap<>();
//
//        for (int i = str.length() - 1; i >= 0; i--)
//        {
//            if(charCount.containsKey(str.charAt(i)))
//            {
//                int count = charCount.get(str.charAt(i));
//                charCount.replace(str.charAt(i), ++count);
//            }
//            else
//            {
//                charCount.put(str.charAt(i),1);
//            }
//        }
//        System.out.println(charCount);
    }

}
