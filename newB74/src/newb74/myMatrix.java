/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newb74;

/**
 *
 * @author buidu
 */
public class myMatrix {

    private int[][] matrix;

    public myMatrix(int row, int col) {
        try {
            matrix = new int[row][col];
        } catch (OutOfMemoryError e) {
            System.err.println("Error: matrix very larger, can't create!");
        }
    }

    public boolean notNull() {
        return matrix != null;
    }

    
    //matrix.length số hàng
    //.matrix[0].length số cột
    public void inputMatrix(int n) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Validation.getInt("Enter Matrix: " + n + "[" + (i + 1) + "][" + (j + 1) + "]: ",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public myMatrix addMatrix(myMatrix m2) {
        if (matrix.length == m2.matrix.length && matrix[0].length == m2.matrix[0].length) {
            myMatrix result = new myMatrix(matrix.length, matrix[0].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result.matrix[i][j] = matrix[i][j] + m2.matrix[i][j];
                }
            }
            return result;
        } else {
            return null;
        }
    }

    public myMatrix subMatrix(myMatrix m2) {
        if (matrix.length == m2.matrix.length && matrix[0].length == m2.matrix[0].length) {
            myMatrix result = new myMatrix(matrix.length, matrix[0].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result.matrix[i][j] = matrix[i][j] - m2.matrix[i][j];
                }
            }
            return result;
        } else {
            return null;
        }
    }

    public myMatrix mulMatrix(myMatrix m2) {
        if (matrix[0].length == m2.matrix.length) {
            myMatrix result = new myMatrix(matrix.length, m2.matrix[0].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < m2.matrix[0].length; j++) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        result.matrix[i][j] += matrix[i][k] * m2.matrix[k][j];
                    }
                }
            }
            return result;
        } else {
            return null;
        }
    }

}
