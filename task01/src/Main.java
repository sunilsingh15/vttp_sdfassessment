import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // following assessment sample output
        System.out.println("Welcome.");

        // new scanner object to accept input from user inside while loop
        Scanner scan = new Scanner(System.in);
        String input = "";

        // declaration of both numbers in expression
        // also result, and last variable for use later
        double num1 = 0.0;
        double num2 = 0.0;
        double result = 0.0;
        double last = 0.0;

        while (!input.equals("exit")) {
            System.out.print("> ");
            // accept input from user after prompt arrow
            input = scan.nextLine();

            // break out of loop if user enters exit, will go to after while loop which will
            // print "Bye bye"
            if (input.equals("exit")) {
                break;
            }

            // split input into a string array to analyze each
            // index and perform tasks accordingly
            String[] expression = input.split(" ");

            // if there are less than 3 terms in expression
            // reject input
            if (expression.length != 3) {
                System.out.println("Expression entered is not valid. Try again.");
                continue;
            }

            // two if statements to check if first or last input entered
            // is equal to $last
            // if so, assign last variable to num1/num2
            // otherwise, convert from string array to a double
            // to perform math operations

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

            // switch statement
            // will check what operator user gives
            // and go into individual case accordingly
            // and perform operation

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

            // once breaks from switch statement, will come here
            // this will print the result for user like sample output
            // and save result value to last variable
            // so we can use $last in future
            System.out.println(result);
            last = result;

        }

        // end of program
        // close resources (Scanner)
        // print message as shown in sample output
        // shut program down
        scan.close();
        System.out.println("Bye bye");
        System.exit(0);
        
    }
}
