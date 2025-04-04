/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newb74;

/**
 *
 * @author buidu
 */
public class NewB74 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        while (true) {
            System.out.println("=== Calculator program ===");
            System.out.println("1. add matrix");
            System.out.println("2. sub matrix");
            System.out.println("3. mul matrix");
            System.out.println("4. quit");
            int op = Validation.getInt("Your choice: ", 1, 4);

            int row1 = Validation.getInt("Enter row matrix1: ", 1, Integer.MAX_VALUE);
            int col1 = Validation.getInt("Enter col matrix1: ", 1, Integer.MAX_VALUE);
            myMatrix m1 = new myMatrix(row1, col1);
            if (!m1.notNull()) {
                continue;
            }
            m1.inputMatrix(1);

            int row2 = Validation.getInt("Enter row matrix2: ", 1, Integer.MAX_VALUE);
            int col2 = Validation.getInt("Enter col matrix2: ", 1, Integer.MAX_VALUE);
            myMatrix m2 = new myMatrix(row2, col2);
            if (!m2.notNull()) {
                continue;
            }
            m2.inputMatrix(2);

            System.out.println("--- Result ---");
            switch (op) {
                case 1:
                    if (m1.addMatrix(m2) != null) {
                        m1.displayMatrix();
                        System.out.println("+");
                        m2.displayMatrix();
                        System.out.println("=");
                        m1.addMatrix(m2).displayMatrix();
                    } else {
                        System.err.println("Can't add 2 matrix!");
                    }
                    break;
                case 2:
                    if (m1.subMatrix(m2) != null) {
                        m1.displayMatrix();
                        System.out.println("-");
                        m2.displayMatrix();
                        System.out.println("=");
                        m1.subMatrix(m2).displayMatrix();
                    } else {
                        System.err.println("Can't sub 2 matrix!");
                    }
                    break;
                case 3:
                    if (m1.mulMatrix(m2) != null) {
                        m1.displayMatrix();
                        System.out.println("*");
                        m2.displayMatrix();
                        System.out.println("=");
                        m1.mulMatrix(m2).displayMatrix();
                    } else {
                        System.err.println("Can't mul 2 matrix!");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

}
