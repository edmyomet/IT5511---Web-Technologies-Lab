import java.util.Scanner;
import java.lang.Math;
class Shape{
    double radius;
    double height;
    float area;
    void draw(){
        System.out.println("Method to draw has been invoked");
    }
    void calculateArea(){
        System.out.println("method to calculate area has been invoked");
    }
    void callAll(){
        draw();
        calculateArea();
    }
}
class Circle extends Shape{
    Circle(){
        /*
         * default constructor
         */
    }
    Circle(double radius, double height){
        this.radius=radius;
        this.height=height;
    }
    void draw(){
        System.out.println("Drawing a circle");
    }
    void calculateArea(){
        this.area = (float)(Math.PI*Math.pow(radius,2));
        System.out.println("The area of the circle is: "+this.area);
    }
    void callAll(){
        draw();
        calculateArea();
    }
}
class Cylinder extends Shape{
    Cylinder(){
        /*
         * default constructor
         */
    }
    Cylinder(double radius, double height){
        this.radius = radius;
        this.height = height;
    }
    void draw(){
        System.out.println("Drawing a cylinder");
    }
    void calculateArea(){
        this.area = (float)(2*Math.PI*this.radius*this.height) + (float)(2*Math.pow(radius,3)*Math.PI);
        System.out.println("The area of the cylinder is: "+this.area);
    }
    void callAll(){
        draw();
        calculateArea();
    }
}
public class polymorphOne {
    public static void main(String[] args){
    Shape base = new Shape();
    Circle subOne = new Circle(12.3, 13.0);
    Cylinder subTwo = new Cylinder(12.3,12.0);
    base.callAll();
    subOne.callAll();
    subTwo.callAll();
}
}