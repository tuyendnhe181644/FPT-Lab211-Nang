package newb21_2;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String input, int min, int max) {
        while (true) {
            System.out.print(input);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("Please input number " + min + "->" + max + "!");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Please input number!");
            }
        }
    }

    public static String getString(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println("Please input not empty!");
            }
        }
    }

    public static String getYN(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N")) {
                return s;
            } else {
                System.err.println("Please input Y/N!");
            }
        }
    }

    public static String getUD(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("U") || s.equalsIgnoreCase("D")) {
                return s;
            } else {
                System.err.println("Please input U/D!");
            }
        }
    }
    
    public static String getCourse(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("java") || s.equalsIgnoreCase(".net") || s.equalsIgnoreCase("c/c++")) {
                return s;
            } else {
                System.err.println("Please input [java]/[.net]/[c/c++]!");
            }
        }
    }

}
