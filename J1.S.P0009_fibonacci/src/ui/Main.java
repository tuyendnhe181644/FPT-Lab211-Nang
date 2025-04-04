/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Fibonacci;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int number = 5;
        System.out.println("The "+number+" sequence fibonacci: ");
        for (int i = 0; i < number; i++) {
            System.out.print(Fibonacci.generateFibonacci(i));
            if(i<number-1){
                System.out.print(", ");
            }else{
                System.out.println(".");
            }
        }
    }

}
