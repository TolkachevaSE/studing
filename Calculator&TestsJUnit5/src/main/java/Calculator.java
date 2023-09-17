import java.util.Scanner;

import static java.lang.Double.*;

public class Calculator {

    private static double r;

    public static void main(String[] args) {

        double a = getNumber(getString());
        String o = checkOperator(getOperator());
        double b = getNumber(getString());


       try {
            getResult(a, o, b);
            outputResult();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
                    }

    }

    public static String getString() {
        // Get the number from the user
        System.out.print("Input a number  ");
        Scanner scan;
        scan = new Scanner(System.in);
        String s = scan.next();
        return s;
    }

    public static double getNumber(String s) {
        double a = 0;

        try {
            s = s.replace(",", ".");
            a = parseDouble(s);
            return a;

        } catch (NumberFormatException numberFormatException) {
            System.out.println("You enter not a number!");
        }
        return NaN;
    }

    public static String getOperator() {
        // Get the operation sign from the user

        System.out.print("Enter an operation sign ( +, -, *, /)  ");
        Scanner scan;
        scan = new Scanner(System.in);
        String op = scan.nextLine();
        return op;
    }

    public static String checkOperator(String op) {

        switch (op) {
            case "+":
            case "*":
            case "-":
            case "/":
                return op;
            default:
                System.out.println("You entered an invalid operator");
                return "wrong";
        }
        }

    public static double getResult(double a, String o, double b) {

        switch(o) {
            case "/":
                if(b==0) {
                    throw new RuntimeException("Can't divide by 0!");
                    }
                else {r=a/b; }
                break;
            case "+": r=a+b;
                break;
            case "-": r=a-b;
                break;
            case "*": r=a*b;
                break;
            default: r=NaN;
        }
        return r;
    }

    public static void outputResult() {

        if (isInfinite(Math.abs(r))) {
            System.out.println("The result is infinity");
        } else if (Double.isNaN(r)) {
            System.out.println("Data entered incorrectly. Unable to get result");
        } else if (Math.abs(r) <= Math.abs(1e9) && Math.abs(r) > Math.abs(1)) {
            System.out.println(String.format("%,f", r));
        } else System.out.println(r);
    }
}


