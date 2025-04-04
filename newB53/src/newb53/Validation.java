/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newb53;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String input, int min, int max) {
        System.out.print(input);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.print("Please input an integer from min to max: ");
                }
            } catch (NumberFormatException ex) {
                System.err.print("Please input an integer: ");
            }
        }
    }
}
