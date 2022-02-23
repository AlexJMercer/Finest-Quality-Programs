import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

public class InfinitePattern {


    public static void Pattern(int rows, char choice, Scanner input) throws InterruptedException
    {        
        // Code for the loop
        if (choice == 'Y' || choice == 'y')
        {
            // For the Infinite Part
            while (true)
            {
                // Normal Triangle
                for (int i = 1; i <= rows; i++)
                {
                    for (int j = 1; j <= i; j++)
                    {
                        System.out.print("* ");         // Prints the row
                    }
                    System.out.println();               // Newline Operator
                    TimeUnit.MILLISECONDS.sleep(15); // Sleep
                }

                // Inverse Triangle
                for (int i = rows; i >= 0; i--)
                {
                    for (int j = 0; j <= i; j++)
                    {
                        System.out.print("* ");         // Prints the row
                    }
                    System.out.println();               // Newline Operator
                    TimeUnit.MILLISECONDS.sleep(15);     // Sleep
                }
            }
        }
        else
        {
            // For the Finite Part
            System.out.print("\nEnter number of Triangles : ");
            int iterations = input.nextInt();
            for (int count=0; count < iterations; count++)
            {
                // Normal Triangle
                for (int i=1; i <= rows; i++)
                {
                    for (int j=1; j <= i; j++)
                    {
                        System.out.print("* ");         // Prints the row
                    }
                    System.out.println();               // Newline Operator
                    TimeUnit.MILLISECONDS.sleep(15); // Sleep
                }

                // Inverse Triangle
                for (int i=rows; i >= 0; i--)
                {
                    for (int j=0; j <= i; j++)
                    {
                        System.out.print("* ");         // Prints the row
                    }
                    System.out.println();               // Newline Operator
                    TimeUnit.MILLISECONDS.sleep(15);     // Sleep
                }
            }
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException{
        int rows;
        char choice;
        Scanner input = new Scanner(System.in);                 // Declaration of the Input Class
                
        try
        {
            System.out.print("\n\nEnter the number of rows per Triangle : ");
            rows = input.nextInt();
            System.out.print("\nDo you want an Infinite Loop ? (Y/N) : ");
            choice = (char) System.in.read();                    // Takes input of next byte

            Pattern(rows, choice, input);                       // Function Call
        }
        finally{
            input.close();
        }
    }
}