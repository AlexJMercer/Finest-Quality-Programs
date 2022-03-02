import java.util.Scanner;
public class MatrixDisplay {
    public static void disp(int matrix[][], int row, int col){

        System.out.println("\nThe matrix is : \n");
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                
                if (col == 1)
                    System.out.print("| " + matrix[i][j] + " |");
                else if (j==0)   
                    System.out.print("| " + matrix[i][j]);
                else if(j>0 && j<col-1)
                    System.out.print(", " + matrix[i][j]);
                else if (j == col-1)
                    System.out.print(", " + matrix[i][j] + " |");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int row, col;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number of Rows and Columns of the Matrix : ");
        row = input.nextInt();
        col = input.nextInt();

        int matrix[][] = new int[row][col];
        System.out.println("\nEnter matrix elements row-wise : \n");

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                System.out.print("Enter elements of Row " + (i+1) + " : ");
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();

        disp(matrix, row, col);
    }
}
