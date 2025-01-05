
package shapeTest;
import shapes.shapes;
import java.util.*;
public class shapeTest extends shapes {
	static void choice() {
		System.out.println("Enter the choice of shapes area you want to calculate");
		System.out.println("1 -- for Circle");
		System.out.println("2 -- for Rectangle");
		System.out.println("3 -- for Triangle");
		System.out.println("4 -- for Square");
	}
	public static void main(String[] args) {
		shapes sh=new shapes();
		Scanner in= new Scanner(System.in);
		choice();
		int ch=in.nextInt();
		while(true) {
			switch(ch) {
			 case 1: 
                 CircleArea circle = sh.new CircleArea();
                 circle.display();
                 break;
             case 2: 
                 RectangleArea rect = sh.new RectangleArea();
                 rect.display();
                 break;
             case 3: 
                 TriangleArea triangle = sh.new TriangleArea();
                 triangle.display();
                 break;
             case 4: 
                 SquareArea square = sh.new SquareArea();
                 square.display();
                 break;
             case 5:
                 System.exit(0);
             default:
                 System.out.println("Invalid input");
                 break;
         }
         choice();
         ch = in.nextInt();
		}

		
		
	}
}
