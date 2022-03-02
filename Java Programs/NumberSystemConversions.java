import java.util.ArrayList;
import java.util.Scanner;

public class NumberSystemConversions {

    public static void divideByBase(long num, byte base) {

        ArrayList<String> preOutput = new ArrayList<String>();

        String baseChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";                             // String containing Alphabets from A-Z for base conversion till base 36            
        int rem;

        while(num != 0)                                                             // Main While Loop for traditional long division method
        {
            rem = (int) Math.floor(num % base);                                     // Obtaining an integer remainder through floor modulo operation which is
                                                                                    // necessary in a few special cases of decimal inputs.
            if(rem < 10)                                                            // For remainder less than 10, the remainder (as integer) is added to the
                preOutput.add(Integer.toString(rem));                               // output String.
            else if(rem >= 10)                                                      // If remainder is greater than 10, then the suitable Alphabetical
                preOutput.add(Character.toString(baseChar.charAt(rem-10)));         // character from the baseChar String is added to the output String.
            num /= base;
        }

        if (base < 8)
        {
            if(preOutput.size() % 4 != 0)
            {
                for(int i=0; i < (preOutput.size() % 4); i++)
                {
                    preOutput.add(preOutput.size(), "0");                           // Adding zeroes if the first group does not have 4 characters
                }
            }
        }
        else if (base == 8)
        {
            if(preOutput.size() % 3 != 0)
            {
                for(int i=0; i < (preOutput.size() % 3); i++)
                {
                    preOutput.add(preOutput.size(), "0");                           // Similarly, adding zeroes to first group if not full.
                }
            }
        }

        System.out.print("Number in base "+ base +" is : ");
        for (int i = preOutput.size()-1; i >= 0; i--)                               // Printing the string backwards and grouping simultaneously
        {
            if (base != 8)                                                          // Grouping up the individual characters into groups of 4 for bases lower than 8
            {
                if (i % 4 == 0)
                {
                    System.out.print(preOutput.get(i)+" ");
                }
                else
                {
                    System.out.print(preOutput.get(i));
                }
            }
            else
            {
                if (i % 3 == 0)                                                     // For base 8, grouping characters into groups of 3
                {
                    System.out.print(preOutput.get(i)+" ");
                }
                else
                {
                    System.out.print(preOutput.get(i));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter a number (Decimal): ");                           // User input prompt for a decimal number (for now)
        long inputNum = input.nextLong();

        System.out.print("\nSelect the base you want to convert to (2-36): ");      // Prompt to convert to a certain base, only supports till 36
        byte choice = input.nextByte();

        switch ((choice >= 2 && choice <= 36) ? 1:2) {                              // Temporary Switch-Case statement
            case 1:
                divideByBase(inputNum, choice);
                break;
            default:
                System.out.println("Invalid Base.");
                break;
        }
        input.close();
    }
}