package build;

import java.io.IOException;

public class ControlFlow {

    public static void main(String[] args)  {


        for(int i = 0;i<10;i++){
            System.out.println(i);

        }

        String[] namesArray = {"rajan","sagar","priyanshu"};

        for(String name: namesArray){
            System.out.println(name);
        }

        try {
            System.out.println("1");
            errorThrow();
            System.out.println("2");
        }catch (IOException e){
            System.out.println(e);
        }

    }

    private static void errorThrow() throws IOException {
        throw new IOException("IOE");
    }


}
