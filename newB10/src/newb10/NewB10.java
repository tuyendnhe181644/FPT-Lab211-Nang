/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newb10;

/**
 *
 * @author buidu
 */
public class NewB10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int size = Validation.getInt("Enter number of array: ", 1, Integer.MAX_VALUE);
        int value = Validation.getInt("Enter value search: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        myArray arr = new myArray(size);
        if(!arr.checkNotNull()){
            System.err.println("Can't create arr");
            return;
        }
        arr.setValue(value);
        arr.randomArr();
        arr.displayArr();
        arr.linearSearch();
    }

}
