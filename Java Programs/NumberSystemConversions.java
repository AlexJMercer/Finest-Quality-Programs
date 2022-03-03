// This idea for this program first popped in my head on 20th February 2022.

// The ultimate purpose of this program will be to convert a number from 
// any base, within the range 2 to 36 to any other base within that same range.

// The logic for this is the ordinary calculations used in Number Theory to
// convert numbers to and from different bases, which is usually always under 16 (Hexadecimal).

// I expanded this concept to further include bases upto 36, at which point the largest
// alphabet we can use is Z.

import java.util.ArrayList;
import java.util.Scanner;

public class NumberSystemConversions {

    public static long baseToDec(String num, byte base) {
        long decimalNum = 0;
        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++)                                      // Converting the String to an integer array
        {
            
            if (Character.isAlphabetic(num.charAt(i)))
            {
                arr[i] = ((int) num.charAt(i))-55;
            }
            else
            {
                arr[i] = (int) num.charAt(i) - '0';
            }
            
        }

        for (int i = num.length()-1, j = 0; i >= 0; i--, j++)                        // Start iterating from back of array
        {
            decimalNum += (arr[i])*Math.pow(base, j);
        }

        return decimalNum;
    }

    public static void decimalToBase(long num, byte base) {

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

        System.out.print("\nEnter base of input number (2-36): ");                  // User input prompt for base of input number
        byte inputBase = input.nextByte();

        System.out.print("\nEnter your number to be converted : ");
        String inputStr = input.next();

        System.out.print("\nSelect the base you want to convert to (2-36): ");      // Prompt to convert to a certain base, only supports till 36
        byte choice = input.nextByte();

        switch ((inputBase == 10) ? 2 : (choice == 10) ? 3 : 1)
        {
            case 1:
                decimalToBase(baseToDec(inputStr, inputBase), choice);              // Any base to any other
                break;
            case 2:
                long inputNum = Long.parseLong(inputStr);
                decimalToBase(inputNum, choice);                                    // From Base 10 to other
                break;
            case 3:
                System.out.println("\nThe Number "+ inputStr +" in Decimal is : "
                                + baseToDec(inputStr, inputBase)+"\n");                  // From different bases to Base 10
                break;
            default:
                System.out.println("Invalid Base.");
                break;
        }
        input.close();
    }
}