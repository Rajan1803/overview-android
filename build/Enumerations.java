package build;

import static build.Day.MONDAY;

public class Enumerations {




        public static void main(String[] args) {
            System.out.println(Color.RED);
//            System.out.println(c1);
//            c1.colorInfo();
            Color cl = Color.BLUE;
            System.out.println(cl);

            Day day = Day.FRIDAY;

            switch (day) {
                case MONDAY:
                    System.out.println("Mondays are bad.");
                    break;
                case FRIDAY:
                    System.out.println("Fridays are better.");
                    break;
                case SATURDAY:
                case SUNDAY:
                    System.out.println("Weekends are best.");
                    break;
                default:
                    System.out.println("Midweek days are so-so.");
                    break;
            }

            Day arr[] = Day.values();

            // enum with loop
            for (Day d : arr) {
                // Calling ordinal() to find index
                // of color.
                System.out.println(d + " at index "
                        + d.ordinal());
            }

            // Using valueOf(). Returns an object of
            // Color with given constant.
            // Uncommenting second line causes exception
            // IllegalArgumentException
            System.out.println(Day.valueOf("MONDAY"));

        }


}
enum Color {
    RED,
    GREEN,
    BLUE;

    // enum constructor called separately for each
    // constant
    private Color()
    {
        System.out.println("Constructor called for : "
                + this.toString());
    }

    public void colorInfo()
    {
        System.out.println("Universal Color");
    }




}

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}


