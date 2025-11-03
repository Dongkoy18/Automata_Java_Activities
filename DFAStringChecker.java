import java.util.Scanner;

public class DFAStringChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary string: ");
        String input = scanner.nextLine();

        boolean isAccepted = checkDFA(input);

        if (isAccepted) {
            System.out.println("String accepted.");
        } else {
            System.out.println("String rejected.");
        }

        scanner.close();
    }

    public static boolean checkDFA(String input) {
        int state = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol != '0' && symbol != '1') {
                System.out.println("Invalid input. Only 0 and 1 are allowed.");
                return false;
            }

            switch (state) {
                case 0 -> state = (symbol == '0') ? 1 : 0;
                case 1 -> state = (symbol == '0') ? 1 : 2;
                case 2 -> state = (symbol == '0') ? 1 : 0;
            }
        }

        return state == 2;
    }
}
