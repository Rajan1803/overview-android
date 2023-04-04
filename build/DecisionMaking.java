package build;

public class DecisionMaking {

    public static void main(String[] args) {

        var age = 22;

        if (age > 10) {
            System.out.println("can ride cycle");
        }else if (age>18) {
            System.out.println("can ride bike and cycle");
        }else {
            System.out.println("cant ride cycle or bike");
        }

        switch (age) {
            case 10:
                System.out.println("age is 10");
                break;
            case 20:
                System.out.println("age is 20");
                break;
            default:
                System.out.println("default");
        }


        for(int i = 0;i<10;i++){
            System.out.println(i);

        }

        String[] namesArray = {"rajan","sagar","priyanshu"};

        for(String name: namesArray){
            System.out.println(name);
        }
    }

}
