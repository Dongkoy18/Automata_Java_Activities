import java.util.Scanner;

public class NFAStringChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean isAccepted = checkNFA(input);

        if (isAccepted) {
            System.out.println("String accepted.");
        } else {
            System.out.println("String rejected.");
        }

        scanner.close();
    }

    public static boolean checkNFA(String input) {
        String state = "q0";

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            switch (state) {
                case "q0" -> {
                    if (symbol == 'a') state = "q1";
                }
                case "q1" -> {
                    state = switch (symbol) {
                        case 'a' -> "q1";
                        case 'b' -> "q2";
                        default -> "q0";
                    };
                }
            }
        }

        return state.equals("q2");
    }
}
