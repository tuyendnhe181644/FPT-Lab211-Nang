/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newb53;

import java.util.Arrays;

/**
 *
 * @author buidu
 */
public class myArray {

    private int[] arr;

    public myArray(int size) {
        try {
            arr = new int[size];
        } catch (OutOfMemoryError e) {
            System.err.println("Size very large, can't create");
            arr = null;
        }
    }

    public boolean notNull() {
        return arr != null;
    }

    public void inputArr() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Validation.getInt("Enter number " + (i + 1) + ": ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public void displayArrAscending() {
        Arrays.sort(arr);
        System.out.println("----- Ascending -----");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
            if (i != arr.length - 1) {
                System.out.print("->");
            }
        }
        System.out.println("");
    }

    public void displayArrDescending() {
        Arrays.sort(arr);
        System.out.println("----- Descending -----");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print("[" + arr[i] + "]");
            if (i != 0) {
                System.out.print("<-");
            }
        }
        System.out.println("");

    }
}
