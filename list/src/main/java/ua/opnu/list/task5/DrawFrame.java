package ua.opnu.list.task5;

import javax.swing.*;
import java.awt.*;
import java.util.*;

abstract class Shape { Color color; public Shape(Color color) { this.color = color; } abstract void draw(Graphics g); }
class Circle extends Shape { int x, y, r; public Circle(int x,int y,int r,Color c){super(c);this.x=x;this.y=y;this.r=r;} void draw(Graphics g){ g.setColor(color); g.fillOval(x,y,r,r); }}
class RectangleShape extends Shape { int x,y,w,h; public RectangleShape(int x,int y,int w,int h,Color c){super(c);this.x=x;this.y=y;this.w=w;this.h=h;} void draw(Graphics g){ g.setColor(color); g.fillRect(x,y,w,h); }}

public class DrawFrame extends JFrame {
    java.util.List<Shape> shapes = new ArrayList<>();
    public DrawFrame() {
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        shapes.add(new Circle(50,50,100,Color.RED));
        shapes.add(new RectangleShape(200,100,120,60,Color.BLUE));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for(Shape s:shapes) s.draw(g);
    }

    public static void main(String[] args){ new DrawFrame().setVisible(true); }
}
