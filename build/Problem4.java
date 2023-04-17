package build;

public class Problem4 {
    // askii value
    public static void main(String[] args) {
//        System.out.println();

        String str = "s1mf0rm";
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result += str.charAt(i);
            }
        }

        int number = Integer.parseInt(result);
        System.out.println(number);

//        for (char i = '0'; i <= '9'; i++) {
//            result+= i;
//            System.out.println("--------");
//            System.out.println(i);
//        }
//        int number = Integer.valueOf(Problem4.getInt("s1mf0rm"));
//        System.out.println(number);

    }
}

//    static String getInt(String str) {
//        str = str.replaceAll("[^\\d.]","");
//
//        return str;
//    }
//
//}
