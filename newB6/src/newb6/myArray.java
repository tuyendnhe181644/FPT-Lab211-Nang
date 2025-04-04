/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newb6;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void sortArr() {
        Arrays.sort(arr);
    }

    public void randomArr() {
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(arr.length);
        }
    }

    public void displayArr() {
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void binarySearch() {
        int mid = 0;
        int left = 0;
        int right = arr.length - 1;
        boolean check = false;
        ArrayList<Integer> result = new ArrayList<>();
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == value) {
                check = true;
                result.add(mid);
                for (int i = mid - 1; i >= 0; i--) {
                    if (arr[i] == value) {
                        result.add(i);
                    } else {
                        break;
                    }
                }
                for (int i = mid + 1; i < arr.length; i++) {
                    if (arr[i] == value) {
                        result.add(i);
                    } else {
                        break;
                    }
                }
                break;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (check == false) {
            System.err.print("Not found " + value + " in the array!");
        } else {
            System.out.print("Found " + value + " at index: ");
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }

}
