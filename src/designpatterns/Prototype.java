package designpatterns;

// Abstract prototype
abstract class Shape implements Cloneable {
    private int x;
    private int y;

    // Default constructor
    public Shape() { }

    // Copy constructor
    public Shape(Shape other) {
        if(other != null) {
            this.x = other.x;
            this.y = other.y;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Clone method
    public abstract Shape clone();
}

// Extended from prototype
class Circle extends Shape {
    private int radius;

    public Circle() { }

    public Circle(Circle other) {
        super(other);
        if(other != null) {
            this.radius = other.radius;
        }
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }
}

public class Prototype {
    public static void main(String[] args) {

    }
}
