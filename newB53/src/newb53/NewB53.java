/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newb53;

/**
 *
 * @author buidu
 */
public class NewB53 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        myArray arr = null;
        while (true) {
            System.out.println("========= Bubble Sort program =========\n"
                    + "1. Input Element\n"
                    + "2. Sort Ascending\n"
                    + "3. Sort Descending\n"
                    + "4. Exit");
            int op = Validation.getInt("Please choice one option: ", 1, 4);
            switch (op) {
                case 1:
                    System.out.println("----- Input Element -----\n"
                            + "Input Length Of Array");
                    int size = Validation.getInt("Enter Number: ", 1, Integer.MAX_VALUE);
                    arr = new myArray(size);
                    if(!arr.notNull()){
                        continue;
                    }
                    arr.inputArr();
                    break;
                case 2:
                    if(arr!=null){
                        arr.displayArrAscending();
                    }else{
                        System.err.println("Please input element");
                    }
                    break;
                case 3:
                    if(arr!=null){
                        arr.displayArrDescending();
                    }else{
                        System.err.println("Please input element");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

}
