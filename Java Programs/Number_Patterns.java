package Class_Practice;

public class Number_Patterns {
    public static void main(String[] args) {
        int rows = 5;
        
        System.out.println("\n(a) First Pattern : ");
        for (int i = rows; i >= 1; --i)
        {
            for (int j = 1; j <= i; ++j)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n_______________\n\n(b) Second Pattern : ");
        for (int i = 1; i <= rows; ++i)
        {
            for (int j = i; j >= 1; --j)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
        System.out.println("\n_______________\n\n(c) Third Pattern : ");
        for (int i = 1; i <= rows; ++i)
        {
            for (int j = rows; j >= i; --j)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n_______________\n\n(d) Fourth Pattern : ");
        for (int i = rows; i >= 1; --i)
        {
            for (int j = rows; j >= i; --j)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n_______________\n\n(e) Fifth Pattern : ");
        for (int i = 1; i <= rows; ++i)
        {
            for (int j = rows-i+1; j >= 1; --j)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
