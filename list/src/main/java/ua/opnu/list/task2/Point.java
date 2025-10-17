package ua.opnu.list.task2;

interface Movable {
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    void moveTo(double x, double y);
}

public class Point implements Movable {
    private double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }

    public void moveTo(double x, double y) { this.x = x; this.y = y; }

    @Override
    public String toString() { return "Point(" + x + ", " + y + ")"; }

    public static void main(String[] args) {
        Point p = new Point(0, 0);
        System.out.println(p);
        p.moveTo(5, 10);
        System.out.println(p);
    }
}
