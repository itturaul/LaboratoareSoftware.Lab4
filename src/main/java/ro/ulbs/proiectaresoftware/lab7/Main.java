package ro.ulbs.proiectaresoftware.lab7;

import ro.ulbs.proiectaresoftware.lab7.forms.Circle;
import ro.ulbs.proiectaresoftware.lab7.forms.Form;
import ro.ulbs.proiectaresoftware.lab7.forms.Square;
import ro.ulbs.proiectaresoftware.lab7.forms.Triangle;
import ro.ulbs.proiectaresoftware.lab7.util.PasswordMaker;

public class Main {
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Triangle tri2 = new Triangle(1.9F, 8.0F, "blue");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getCounter());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        Form f1 = new Form();
        Form f2 = new Form();
        Form f3 = new Form();
        System.out.println("Numarul total de instante create este: " + Form.getCounter());
        Form f4 = new Form();
        System.out.println("Dupa inca o creare, contorul este: " + Form.getCounter());

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: "+PasswordMaker.getCallingCounts());

    }
}