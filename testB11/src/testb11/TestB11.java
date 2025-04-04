/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testb11;

import java.math.BigInteger;
import java.util.Scanner;

public class TestB11 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Input base =====");
            System.out.println("1. binary");
            System.out.println("2. decimal");
            System.out.println("3. hexadecimal");
            System.out.println("4. exit");
            int op = checkInt("Please choose option: ", "Please choose option(1-4): ", 1, 4);
            switch (op) {
                case 1:
                    String bin = checkBin("input binary: ", "input 0-1: ");
                    System.out.println("===== Output base =====");
                    System.out.println("1. decimal");
                    System.out.println("2. hexadecimal");
                    int opBin = checkInt("Please choose option: ", "Please choose option(1-2): ", 1, 2);
                    if (opBin == 1) {
                        System.out.println(bin + "(bin) -> " + convertOtherToDec(bin, 2) + "(dec)");
                    }
                    if (opBin == 2) {
                        System.out.println(bin + "(bin) -> " + convertDecToOther(convertOtherToDec(bin, 2), 16));
                    }
                    System.out.println("");
                    break;

                case 2:
                    String dec = checkDec("input decimal: ", "input 0-9: ");
                    System.out.println("===== Output base =====");
                    System.out.println("1. binary");
                    System.out.println("2. hexadecimal");
                    int opDec = checkInt("Please choose option: ", "Please choose option(1-2): ", 1, 2);
                    if (opDec == 1) {
                        System.out.println(dec + "(dec) -> " + convertDecToOther(new BigInteger(dec), 2) + "(bin)");
                    }
                    if (opDec == 2) {
                        System.out.println(dec + "(dec) -> " + convertDecToOther(new BigInteger(dec), 16) + "(hex)");
                    }
                    System.out.println("");
                    break;

                case 3:
                    String hex = checkHex("input hexadecimal: ", "input 0-1 and A-f: ");
                    System.out.println("===== Output base =====");
                    System.out.println("1. binary");
                    System.out.println("2. decimal");
                    int opHex = checkInt("Please choose option: ", "Please choose option(1-2): ", 1, 2);
                    if (opHex == 1) {
                        System.out.println(hex + "(hex) -> " + convertDecToOther(convertOtherToDec(hex, 16), 2) + "(bin)");
                    }
                    if (opHex == 2) {
                        System.out.println(hex + "(hex) -> " + convertOtherToDec(hex, 16) + "(dec)");
                    }
                    System.out.println("");
                    break;
                case 4:
                    return;
            }
        }
    }

    public static int checkInt(String input, String err, int min, int max) {
        System.out.print(input);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.print(err);
                }
            } catch (NumberFormatException ex) {
                System.err.print("Please input a number: ");
            }
        }
    }

    public static String checkBin(String input, String err) {
        System.out.print(input);
        while (true) {
            String s = sc.nextLine();
            if (s.matches("[0-1]+")) {
                return s;
            } else {
                System.err.print(err);
            }
        }
    }

    public static String checkDec(String input, String err) {
        System.out.print(input);
        while (true) {
            String s = sc.nextLine();
            if (s.matches("[0-9]+")) {
                return s;
            } else {
                System.err.print(err);
            }
        }
    }

    public static String checkHex(String input, String err) {
        System.out.print(input);
        while (true) {
            String s = sc.nextLine();
            if (s.matches("[0-9a-fA-F]+")) {
                return s;
            } else {
                System.err.print(err);
            }
        }
    }

//    // Chuyển đổi từ thập phân sang các hệ cơ số khác
//    public static String convertDecToOther(BigInteger dec, int base) {
//        return dec.toString(base);
//    }
//
//    // Chuyển đổi từ hệ cơ số khác về thập phân
//    public static BigInteger convertOtherToDec(String other, int base) {
//        return new BigInteger(other, base);
//    }
    public static String convertDecToOther(BigInteger dec, int base) {
        String hex = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();
        while (dec.compareTo(BigInteger.ZERO) > 0) {
            result.insert(0, hex.charAt(dec.mod(BigInteger.valueOf(base)).intValue()));
            dec = dec.divide(BigInteger.valueOf(base));
        }
        return result.toString();
    }

    public static BigInteger convertOtherToDec(String other, int base) {
        String hex = "0123456789ABCDEF";
        other = other.toUpperCase();
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < other.length(); i++) {
            int value = hex.indexOf(other.charAt(i));
            result = result.add(BigInteger.valueOf(value).multiply(BigInteger.valueOf(base).pow(other.length() - 1 - i)));
        }
        return result;
    }

}
