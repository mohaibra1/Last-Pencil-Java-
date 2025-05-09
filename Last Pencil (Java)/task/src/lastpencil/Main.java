package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for number of pencils
        int number;
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = sc.nextLine();

            try {
                number = Integer.parseInt(input);

                if (number > 0) {
                    break;
                } else {
                    if(number < 0){
                        System.out.println("The number of pencils should be numeric");
                    }else {
                        System.out.println("The number of pencils should be positive");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        // Ask who goes first
        //sc.nextLine(); // Consume newline
        String firstPlayer;
        while (true) {
            System.out.println("Who will be the first (John, Jack):");
            firstPlayer = sc.nextLine();
            if (firstPlayer.equals("John") || firstPlayer.equals("Jack")) {
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

        String currentPlayer = firstPlayer;

        while (number > 0) {
            System.out.println("|".repeat(number));
            System.out.printf("%s's turn!%n", currentPlayer);

            int take;
            while (true) {
                if (sc.hasNextInt()) {
                    take = sc.nextInt();
                    if (take >= 1 && take <= 3) {
                        if (take <= number) {
                            break;
                        } else {
                            System.out.println("Too many pencils were taken");
                        }
                    } else {
                        System.out.println("Possible values: '1', '2', or '3'");
                    }
                } else {
                    System.out.println("Possible values: '1', '2', or '3'");
                    sc.next(); // Clear invalid input
                }
            }

            number -= take;

            // Switch players
            currentPlayer = currentPlayer.equals("John") ? "Jack" : "John";
        }

        System.out.printf("%s won!%n", currentPlayer);
        sc.close();
    }
}
