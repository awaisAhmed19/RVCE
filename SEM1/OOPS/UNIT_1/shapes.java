package shapes;

import java.util.Scanner;

public class shapes {
    protected static final double PI = 3.14; // Use constant for PI
    protected double length, height, radius, breadth;
    Scanner in = new Scanner(System.in);

    // Default Constructor
    public shapes() {
        this.length = 0;
        this.height = 0;
        this.radius = 0;
        this.breadth = 0;
    }

    // Inner class for Square Area
    public class SquareArea {
        private double side;

        public void input() {
            System.out.println("Enter side of square:");
            side = in.nextDouble();
        }

        public double calculate() {
            input();
            return side * side;
        }

        public void display() {
            System.out.println("Area of the square: " + calculate());
        }
    }

    // Inner class for Triangle Area
    public class TriangleArea {
        private double length, height;

        public void input() {
            System.out.println("Enter the length:");
            length = in.nextDouble();
            System.out.println("Enter the height:");
            height = in.nextDouble();
        }

        public double calculate() {
            input();
            return 0.5 * length * height;
        }

        public void display() {
            System.out.println("Area of the triangle: " + calculate());
        }
    }

    // Inner class for Rectangle Area
    public class RectangleArea {
        private double length, height;

        public void input() {
            System.out.println("Enter the length:");
            length = in.nextDouble();
            System.out.println("Enter the height:");
            height = in.nextDouble();
        }

        public double calculate() {
            input();
            return length * height;
        }

        public void display() {
            System.out.println("Area of the rectangle: " + calculate());
        }
    }

    // Inner class for Circle Area
    public class CircleArea {
        private double radius;

        public void input() {
            System.out.println("Enter radius of circle:");
            radius = in.nextDouble();
        }

        public double calculate() {
            input();
            return PI * radius * radius;
        }

        public void display() {
            System.out.println("Area of the circle: " + calculate());
        }
    }
}
