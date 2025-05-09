package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        int number = sc.nextInt();
        System.out.println("Who will be the first (John, Jack):");
        String name = sc.next();
        String sticks = "|".repeat(number);
        System.out.printf("%s%n%s is going first!", sticks, name);

    }
}
