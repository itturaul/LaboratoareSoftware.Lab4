package ro.ulbs.proiectaresoftware.lab7.forms;

public class Form {
    private String color;

    public Form() {
        color = "white";
    }

    public Form(String color) {
        this.color = color;
    }

    public float getArea() {
        return 0;
    }

    public String toString() {
        return "This form has the color " + color;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Form) {
            Form f = (Form) obj;
            if (this.color == null && f.color == null) {
                return true;
            } else if (this.color != null && f.color != null && this.color.compareTo(f.color) == 0) {
                return true;
            }
        }
        return false;
    }
}
public class Form {
    private static int counter = 0;

    public Form() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}