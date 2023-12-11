class Lab5_Shapes {
    public static void main(String[] args) {
        System.out.printf("The area of image 1 (The one that looks like a hotdog with a weird middle) is %.3f%n", imageOne());
        System.out.printf("The area of image 2 (APCS) is %.3f%n", imageTwo());
        System.out.printf("The area of image 3 (The house) is %.3f%n", imageThree());
    }

    public static double imageOne() {
        double area = 0;

        // Create shapes and calculate areas for Image 1
        Circle circle = new Circle(2, false);
        Rectangle rectangle1 = new Rectangle(3, 5, false);
      	Rectangle rectangle2 = new Rectangle(3, 5, false);
        Rectangle rectangle3 = new Rectangle(2, 20, false);
      	Rectangle rectangle4 = new Rectangle(2,20, false);
		Rectangle rectangle5 = new Rectangle(3,1, false);      
        area += circle.getArea();
        area += rectangle1.getArea();
      	area += rectangle2.getArea();
      	area += rectangle3.getArea();
      	area += rectangle4.getArea();
      	area += rectangle5.getArea();
        return area;
    }

    public static double imageTwo() {
        double area = 0;

        // Create shapes and calculate areas for Image 2
        Rectangle rectangle1 = new Rectangle(6, 1, false);
        Rectangle rectangle2 = new Rectangle(6, 1, false);
      	Rectangle rectangle3 = new Rectangle(3,1, false);
      	Triangle triangle1 = new Triangle(1,1,false);
      	Triangle triangle2 = new Triangle(1,1,false);
      	Rectangle rectangle4 = new Rectangle(13,1, false);
      	Rectangle rectangle5 = new Rectangle(11,1,false);
      	Triangle triangle3 = new Triangle(3,1,false);
      	Rectangle rectangle6 = new Rectangle(16,1,false);
      
        area += rectangle1.getArea();
        area += rectangle2.getArea();
      	area += rectangle3.getArea();
        area += triangle1.getArea();
      	area += triangle2.getArea();
      	area += rectangle4.getArea();
      	area += rectangle5.getArea();
      	area += triangle3.getArea();
      	area += rectangle6.getArea();

        return area;
    }

    public static double imageThree() {
        double area = 0;

        // Create shapes and calculate areas for Image 3
		Rectangle rectangle1 = new Rectangle(42.35,1, false);
      	Rectangle rectangle2 = new Rectangle(19.8,1,false); //this is supposed to be the roof but I'm lazy
      	Rectangle rectangle3 = new Rectangle(1,1.5,false);
      	Triangle triangle1 = new Triangle(1,2.5,false);
      	Circle circle = new Circle(1,false);
      	Circle circle2 = new Circle(1.5,false);
      	Circle circle3 = new Circle(2,false);
      	
      	area += rectangle1.getArea();
      	area += rectangle2.getArea();
      	area += rectangle3.getArea();
      	area += triangle1.getArea();
      	area += circle.getArea();
      	area += circle2.getArea();
      	area += circle3.getArea();
      	

        return area;
    }
}

class Circle {
    private double radius;
    private boolean isNegativeSpace;

    Circle(double radius, boolean isNegativeSpace) {
        this.radius = radius;
        this.isNegativeSpace = isNegativeSpace;
    }

    double getArea() {
        double area = Math.PI * radius * radius;
        return isNegativeSpace ? -area : area;
    }
}

class Rectangle {
    private double width;
    private double height;
    private boolean isNegativeSpace;

    Rectangle(double width, double height, boolean isNegativeSpace) {
        this.width = width;
        this.height = height;
        this.isNegativeSpace = isNegativeSpace;
    }

    double getArea() {
        double area = width * height;
        return isNegativeSpace ? -area : area;
    }
}

class Triangle {
    private double base;
    private double height;
    private boolean isNegativeSpace;

    Triangle(double base, double height, boolean isNegativeSpace) {
        this.base = base;
        this.height = height;
        this.isNegativeSpace = isNegativeSpace;
    }

    double getArea() {
        double area = 0.5 * base * height;
        return isNegativeSpace ? -area : area;
    }
}