package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        int number = sc.nextInt();
        System.out.println("Who will be the first (John, Jack):");
        StringBuilder name = new StringBuilder(sc.next());
        String sticks = "|".repeat(number);
        //System.out.printf("%s%n%s is going first!", sticks, name);
        int n = number;
        while(number != 0){
            System.out.printf("%s's turn:%n%s%n", name, sticks);
            int next = sc.nextInt();
            number = number - next;
            sticks = "|".repeat(number);

            if(name.toString().equals("Jack")){
                name = new StringBuilder("John");
            }else {
                name = new StringBuilder("Jack");
            }
        }


    }
}
