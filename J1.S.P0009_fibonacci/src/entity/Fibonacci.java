/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */
public class Fibonacci {

    public static int generateFibonacci(int number) {
        switch (number) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return generateFibonacci(number-1)+generateFibonacci(number-2);
        }
    }
}
