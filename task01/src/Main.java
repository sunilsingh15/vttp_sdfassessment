import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome.");

        Scanner scan = new Scanner(System.in);
        String input = "";

        double num1 = 0.0;
        double num2 = 0.0;
        double result = 0.0;
        double last = 0.0;

        while (!input.equals("exit")) {
            System.out.print("> ");
            input = scan.nextLine();

            if (input.equals("exit")) {
                break;
            }

            String[] expression = input.split(" ");

            if (expression.length != 3) {
                System.out.println("Expression entered is not valid. Try again.");
                continue;
            }

            if (expression[0].equals("$last")) {
                num1 = last;
            } else {
                num1 = Double.parseDouble(expression[0]);
            }

            if (expression[2].equals("$last")) {
                num2 = last;
            } else {
                num2 = Double.parseDouble(expression[2]);
            }

            switch (expression[1]) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Expression not valid. Please try again.");
                    continue;
            }

            System.out.println(result);
            last = result;

        }

        scan.close();
        System.out.println("Bye bye");
        System.exit(0);
        
    }
}
