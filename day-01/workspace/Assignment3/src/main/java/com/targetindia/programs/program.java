package com.targetindia.programs;

public class program {
    public static void main(String[] args) {
        Shape[] arr = {new Circle(2.0,"yellow",true),new Square(5,"green",true),new Circle(2.0,"pink",true),new Circle(3.0,"pink",false),new Rectangle(2,3,"red",false)};
        for (Shape x : arr) {
            double d=x.getPerimeter();
            System.out.println("perimeter :"+d);
            d=x.getArea();
            System.out.println("area:"+d);
//            if (x instanceof Circle) {
//                Circle c = (Circle) x;
//                System.out.println("Perimeter of Circle: " + c.getPerimeter());
//                System.out.println("Area of Circle: " + c.getArea());
//            } else if (x instanceof Rectangle) {
//                Rectangle r = (Rectangle) x;
//                System.out.println("Perimeter of Rectangle: " + r.getPerimeter());
//                System.out.println("Area of Rectangle: " + r.getArea());
//            }
        }
    }
}