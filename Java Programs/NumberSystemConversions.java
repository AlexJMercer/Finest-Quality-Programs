import java.util.ArrayList;
import java.util.Scanner;

public class NumberSystemConversions {

    public static void divideByBase(long num, byte base) {
        ArrayList<String> preOutput = new ArrayList<String>();
        String baseChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int rem;
        while(num != 0)
        {
            rem = (int) Math.floor(num % base);
            if(rem < 10)
                preOutput.add(Integer.toString(rem));
            else if(rem >= 10)
                preOutput.add(Character.toString(baseChar.charAt(rem-10)));
            num /= base;
        }

        if (base < 8)
        {
            if(preOutput.size() % 4 != 0)
            {
                for(int i=0; i < (preOutput.size() % 4); i++)
                {
                    preOutput.add(preOutput.size(), "0");
                }
            }
        }
        else if (base == 8)
        {
            if(preOutput.size() % 3 != 0)
            {
                for(int i=0; i < (preOutput.size() % 3); i++)
                {
                    preOutput.add(preOutput.size(), "0");
                }
            }
        }

        System.out.print("Number in base "+ base +" is : ");
        for (int i = preOutput.size()-1; i >= 0; i--)
        {
            if (base != 8)
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
                if (i % 3 == 0)
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

        System.out.print("\nEnter a number (Decimal): ");
        long inputNum = input.nextLong();

        System.out.print("\nSelect the base you want to convert to (2-36): ");
        byte choice = input.nextByte();

        switch ((choice >= 2 && choice <= 36) ? 1:2) {
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