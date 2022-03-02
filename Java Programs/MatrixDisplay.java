// This program is to display a matrix of any dimension (user input)
// in the command line, by using the vertical bar symbol "|" as the
// matrix brackets. The elements are separated using commas.
// This program is created by me, Tathagata Guha Ray on 20th February 2021.

import java.util.Scanner;
public class MatrixDisplay {

    public static void disp(int matrix[][], int row, int col) {                         // Display Function

        System.out.println("\nThe matrix is : \n");
        for(int i=0; i<row; i++)                                                        // For loop to print the matrix elements row-wise
        {
            for(int j=0; j<col; j++)
            {                
                if (col == 1)
                    System.out.print("| " + matrix[i][j] + " |");                       // Specific condition to check for a Column Matrix
                else if (j==0)   
                    System.out.print("| " + matrix[i][j]);                              // Matrix element at the beginning of a row
                else if(j>0 && j<col-1)
                    System.out.print(", " + matrix[i][j]);                              // Elements not at the beginning or the end of the row
                else if (j == col-1)
                    System.out.print(", " + matrix[i][j] + " |");                       // Elements at the end of the row
            }
            System.out.println();                                                       // Newline for the next row
        }
    }
    public static void main(String[] args) {
        int row, col;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number of Rows and Columns of the Matrix : ");
        row = input.nextInt();
        col = input.nextInt();

        int matrix[][] = new int[row][col];                                             // Creating 2D array for the matrix.                            
        System.out.println("\nEnter matrix elements row-wise : \n");

        for(int i=0; i<row; i++)                                                        // For Loop for input of matrix elements manually, row-wise
        {
            for(int j=0; j<col; j++)
            {
                System.out.print("Enter elements of Row " + (i+1) + " : ");
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();

        disp(matrix, row, col);                                                         // Display function called
    }
}
