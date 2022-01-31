package com.example.core;

import java.util.Scanner;

interface ShapeHandler{

    void circle(double radius);
    void rectangle(double length, double width);
    void triangle(double a, double b, double c);
    void square(double side);
    void sphere(double radius);
    void cylinder(double radius, double height);
}

class Shape implements ShapeHandler{

    private double radius;
    private double length;
    private double width;
    private double height;
    private double side;
    private double a;
    private double b;
    private double c;
    private double perimeter;
    private double area;

    @Override
    public void circle(double radius) {

        this.radius = radius;

        this.perimeter = 2 * Math.PI * radius;
        this.area = Math.PI * radius * radius;

        System.out.println("Perimeter is = " + perimeter);
        System.out.println("Area is = " + area);
    }

    @Override
    public void rectangle(double length, double width) {

        this.length = length;
        this.width = width;

        this.area = length * width;
        this.perimeter = 2 * (length + width);

        System.out.println("Area of rectangle is : " + area);
        System.out.println("Perimeter of rectangle is : " + perimeter);
    }

    @Override
    public void triangle(double a, double b, double c) {

        double s;       //for storing the value of semi perimeter
        this.a = a;
        this.b = b;
        this.c = c;

        this.perimeter = a + b + c;
        s = (a + b + c)/2;          // Perimeter/2 for semi perimeter
        this.area = Math.sqrt(perimeter * (s - a) * (s - b) * (s - c));

        System.out.println("The Perimeter of Triangle :" + perimeter);
        System.out.println("The Semi Perimeter of Triangle :" + s);
        System.out.println("The Area of triangle :" + area);

    }

    @Override
    public void square(double side) {

        this.side = side;

        this.perimeter = 4 * side;
        this.area = side * side;

        System.out.println("Area of square is : " + area);
        System.out.println("Perimeter of square is :" + perimeter);

    }

    @Override
    public void sphere(double radius) {

        double volume;      //for storing the value of sphere
        this.radius = radius;

        volume = (4 * 22 * radius * radius * radius) / (3 * 7);

        System.out.println("Volume is :" + volume);

    }

    @Override
    public void cylinder(double radius, double height) {

        double surfaceArea;
        double volume;

        this.radius = radius;
        this.height = height;

        surfaceArea = 2 * Math.PI * radius * (radius + height);     //SurfaceArea of Cylinder
        volume = Math.PI * radius * radius * height;        //Volume of Cylinder

        System.out.println("Surface Area of Cylinder :" + surfaceArea);
        System.out.println("volume of Cylinder :" + volume);


    }
}       //end of Shape Class

public class ShapeAdaptor {
    public static void main(String[] args) {
        int choice;
        double radius;
        double length;
        double width;
        double height;
        double side;
        double a;
        double b;
        double c;

        Shape obj1 = new Shape();       //Object of Shape class is created

        do{
            try{
                System.out.println("Select the shape to calculate area and perimeters for :");
                System.out.println("\t1) Circle");
                System.out.println("\t2) Rectangle ");
                System.out.println("\t3) Triangle");
                System.out.println("\t4) Square");
                System.out.println("\t5) Sphare");
                System.out.println("\t6) Cylinder");
                System.out.println("\t7) Exit");
                System.out.println("Enter a number between the range:");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();

                switch (choice) {

                    case 1: {
                        try {
                             System.out.println("Enter radius :");
                             radius = sc.nextDouble();

                             if(radius <= 0) {
                                 throw new ArithmeticException("Please enter right value");
                             } else {
                                obj1.circle(radius);        //Circle method is being called
                             }

                        } catch(ArithmeticException e) {
                            System.out.println("invalid number");
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    }

                    case 2: {
                        try {
                            System.out.println("Enter Length :");
                            length = sc.nextDouble();

                            System.out.println("Enter Width :");
                            width = sc.nextDouble();

                            if(length <= 0 || width <= 0) {
                                throw new ArithmeticException("Please enter right value");
                            } else {
                                obj1.rectangle(length, width);      //Rectangle method is being called
                            }

                        } catch (ArithmeticException e){
                            System.out.println("invalid number");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    }

                    case 3: {
                        try {
                            System.out.println("Please Enter Three sides of triangle :");
                            a = sc.nextDouble();
                            b = sc.nextDouble();
                            c = sc.nextDouble();

                            if(a <= 0 || b <= 0 || c <= 0) {
                                throw new ArithmeticException("Please enter right value");
                            } else {
                                obj1.triangle(a, b, c);     //Triangle method is being called
                            }

                        } catch (ArithmeticException e) {
                            System.out.println("invalid number");
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    }

                    case 4: {
                        try {
                            System.out.println("Enter side of square :");
                            side = sc.nextDouble();

                            if(side <= 0) {
                                throw new ArithmeticException("Please enter right value");
                            } else {
                                obj1.square(side);      //Square method is being called
                            }

                        } catch (ArithmeticException e) {
                            System.out.println("invalid number");
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    }

                    case 5: {
                        try {
                            System.out.println("Enter the radius of sphere :");
                            radius = sc.nextDouble();

                            if(radius <= 0) {
                                throw new ArithmeticException("Please enter right value");
                            } else {
                                obj1.sphere(radius);        //Sphere method is being called
                            }

                        } catch(ArithmeticException e) {
                            System.out.println("invalid number");
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    }

                    case 6: {
                        try {
                            System.out.println("Enter Base Radius of Cylinder :");
                            radius = sc.nextDouble();

                            System.out.println("Enter Height of Cylinder :");
                            height = sc.nextDouble();

                            if(radius <= 0 || height <= 0) {
                                throw new ArithmeticException("Please enter right value");
                            } else {
                                obj1.cylinder(radius, height);      //cylinder method is being called
                            }

                        } catch(ArithmeticException e) {
                            System.out.println("invalid number");
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    }

                    case 7: {
                        System.out.println("All done");
                        return;
                    }
                    default:{
                        System.out.println("Please choose right option");
                        break;
                    }
                }       //end of switch-case statement
            }
            catch(Exception e){
                System.out.println("illegal value for this parameter");
            }

        }while (true);
    }       //end of main method
}       //end of ShapeAdaptor Class
