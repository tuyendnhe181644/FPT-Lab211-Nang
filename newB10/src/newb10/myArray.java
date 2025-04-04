/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newb10;

import java.util.Random;

/**
 *
 * @author buidu
 */
public class myArray {

    private int[] arr;
    private int value;

    public myArray(int size) {
        try {
            arr = new int[size];
        } catch (OutOfMemoryError e) {
            System.err.println("Size very large");
            arr = null;
        }
    }

    public boolean checkNotNull() {
        return arr != null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void randomArr() {
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(arr.length);
        }
    }

    public void displayArr() {
        System.out.print("The array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void linearSearch() {
        boolean found = false;
        boolean first = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                if (found == false) { // Kiểm tra nếu found là false
                    System.out.print("Found " + value + " at index: ");
                    found = true;
                }

                if (first == false) { // Kiểm tra nếu first là false
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false; // Đánh dấu rằng không phải lần in đầu tiên nữa
            }
        }

        if (found == false) { // Kiểm tra nếu found là false, tức là không tìm thấy giá trị
            System.out.print("Can't find " + value);
        }
    }

}
