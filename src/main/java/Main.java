import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String args[]) {
        Calculator calc = new Calculator();

        if(args[0].equals("add")) {
            System.out.println(calc.add(parseInt(args[1]), parseInt(args[2])));
        } else if(args[0].equals("subtract")) {
            System.out.println(calc.subtract(parseInt(args[1]), parseInt(args[2])));
        } else if(args[0].equals("multiply")) {
            System.out.println(calc.multiply(parseInt(args[1]), parseInt(args[2])));
        } else if(args[0].equals("divide")) {
            System.out.println(calc.divide(parseInt(args[1]), parseInt(args[2])));
        } else if(args[0].equals("binary")) {
            System.out.println(calc.intToBinaryNumber(parseInt(args[1])));
        } else if(args[0].equals("fibonacci")) {
            System.out.println(calc.fibonacciNumberFinder(parseInt(args[1])));
        }
    }
}
