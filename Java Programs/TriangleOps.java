import java.util.Scanner;

public class TriangleOps {
    public static void main(String[] args) {
        double side_a, side_b, hypotenuse, perimeter, area;
        float elevationAngle, depressionAngle;
        Scanner input = new Scanner(System.in);
        try{
            System.out.print("\n\nEnter value for vertical edge of Triangle : ");
            side_a = (double) input.nextDouble();            
            System.out.print("Enter value for horizontal edge of Triangle : ");
            side_b = (double) input.nextDouble();
        }
        finally{
            input.close();
        }
        hypotenuse = Math.sqrt(Math.pow(side_a, 2) + Math.pow(side_b, 2));  // Hypotenuse
        perimeter = side_a + side_b + hypotenuse;                           // Perimeter
        area = (side_a * side_b)/2;

        elevationAngle = (float) Math.toDegrees((float) Math.atan(side_a/side_b));
        depressionAngle = (float) Math.toDegrees((float) Math.asin(side_b/hypotenuse));


        System.out.println("\n\nThe Hypotenuse of the Triangle is : " + hypotenuse + " units");
        System.out.println("The Perimeter of the Triangle is : " + perimeter + " units");
        System.out.println("The Area of the Triangle is : "+ area + " sq. units");
        System.out.println("The Angle of Elevation is : "+ elevationAngle + " degrees");
        System.out.println("The Angle of Depression is : " + depressionAngle + " degrees");
    }
    
}
