package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for pencils of pencils
        int pencils;
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = sc.nextLine();

            try {
                pencils = Integer.parseInt(input);

                if (pencils > 0) {
                    break;
                } else {
                    if(pencils < 0){
                        System.out.println("The number of pencils should be numeric");
                    }else {
                        System.out.println("The number of pencils should be positive");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        // Get first player
        String player;
        while (true) {
            System.out.println("Who will be the first (John, Jack):");
            player = sc.nextLine();
            if (player.equals("John") || player.equals("Jack")) {
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

        // Game loop
        while (pencils > 0) {
            // Show pencils
            System.out.println("|".repeat(pencils));
            System.out.printf("%s's turn:\n", player);

            int move;

            if (player.equals("John")) {
                // User move
                while (true) {
                    String input = sc.nextLine();
                    try {
                        move = Integer.parseInt(input);
                        if (move < 1 || move > 3) {
                            System.out.println("Possible values: '1', '2' or '3'");
                        } else if (move > pencils) {
                            System.out.println("Too many pencils were taken");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Possible values: '1', '2' or '3'");
                    }
                }
            } else {
                // Bot move using winning strategy
                move = botMove(pencils);
                System.out.println(move);
            }

            pencils -= move;

            // Check winner
            if (pencils == 0) {
                System.out.printf("%s won!\n", player.equals("John") ? "Jack" : "John");
                break;
            }

            // Switch player
            player = player.equals("John") ? "Jack" : "John";
        }
    }

    // Bot logic
    public static int botMove(int pencils) {
        if (pencils % 4 == 0) {
            return 3;
        } else if (pencils % 4 == 3) {
            return 2;
        } else if (pencils % 4 == 2) {
            return 1;
        } else {
            // Losing position: pick random 1 to 3, but not more than remaining pencils
            return Math.min(new Random().nextInt(3) + 1, pencils);
        }
    }
}
