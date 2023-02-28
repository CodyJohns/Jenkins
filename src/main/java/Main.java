import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String argv[]) {
        Calculator calc = new Calculator();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("input: ");
            String cmd = in.nextLine();
            String args[] = cmd.split(" ");

            if (args[0].equals("add")) {
                System.out.println(calc.add(parseInt(args[1]), parseInt(args[2])));
            } else if (args[0].equals("subtract")) {
                System.out.println(calc.subtract(parseInt(args[1]), parseInt(args[2])));
            } else if (args[0].equals("multiply")) {
                System.out.println(calc.multiply(parseInt(args[1]), parseInt(args[2])));
            } else if (args[0].equals("divide")) {
                System.out.println(calc.divide(parseInt(args[1]), parseInt(args[2])));
            } else if (args[0].equals("binary")) {
                System.out.println(calc.intToBinaryNumber(parseInt(args[1])));
            } else if (args[0].equals("fibonacci")) {
                System.out.println(calc.fibonacciNumberFinder(parseInt(args[1])));
            } else if (args[0].equals("quit")) {
                break;
            }
        }
    }
}
