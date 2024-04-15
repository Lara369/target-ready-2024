package com.targetindia.programs;
public abstract class Shape {
    public String color = "red";
    public boolean filled = true;
    public Shape(){
    }
    public Shape(String color, boolean filled){
        this.color=color;
        this.filled=filled;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color=color;
    }
    public boolean isFilled(){
        return this.filled;
    }

    public void setFilled(boolean filled){
        this.filled=filled;
    }

    public String toString(){
        String color = getColor();
        String fill;
        if(isFilled()){
            fill = "filled";
        }
        else{
            fill = "Not filled";
        }
        String ans ="| Shape | " + "A Shape with color of "+ color+" and "+fill;
        return ans;
    }
    public abstract double getPerimeter();
    public abstract double getArea();
}
class Circle extends Shape {
    public double radius = 1.0;
    public Circle(){}
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius=radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius){
        this.radius=radius;
    }

    public double getArea(){
        double r = this.radius;
        double ans = Math.PI*r*r;
        return ans;
    }

    public double getPerimeter(){
        return (2*Math.PI*this.radius);
    }

    public String toString(){
        String x= super.toString();
        String s = "| Circle | A Circle with radius " + this.radius + ", which is a subclass of " + x;
        return s;
    }
}

class Rectangle extends Shape{
    double width = 1.0;
    double length = 1.0;
    public Rectangle(){}
    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width=width;
    }

    public double getLength(){
        return this.length;
    }
    public void setLength(double length){
        this.length=length;
    }

    public double getArea(){
        return (this.length * this.width);
    }
    public double getPerimeter(){
        return 2*(this.length + this.width);
    }

    public String toString(){
        String x= super.toString();
        String s = "| Rectangle | A Rectangle with width " + this.width +" and length " + this.length+ ", which is a subclass of " + x;
        return s;
    }
}

class Square extends Rectangle{
    public Square(){}
    public Square(double side){
        this.width =side;
        this.length = side;
    }
    public Square(double side,String color, boolean filled){
        super(side,side,color,filled);
    }

    public double getSide(){
        return this.width;
    }
    public void setSide(double side){
        this.width = side;
    }
    public void setLength(double side){
        this.length = side;
    }
    public void setWidth(double side){
        this.width = side;
    }
    public String toString(){
        String x= super.toString();
        String s = "| Square | A Square with side " + this.width + ", which is a subclass of " + x;
        return s;
    }

}