package ua.opnu.list.task5;

import javax.swing.*;
import java.awt.*;
import java.util.*;

// Абстрактний клас форми
abstract class Shape {
    Color color;
    public Shape(Color color) {
        this.color = color;
    }
    abstract void draw(Graphics g);
}

// Клас кола
class Circle extends Shape {
    int x, y, r;
    public Circle(int x, int y, int r, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.r = r;
    }
    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, r, r);
    }
}

// Клас прямокутника
class RectangleShape extends Shape {
    int x, y, w, h;
    public RectangleShape(int x, int y, int w, int h, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);
    }
}

// Панель для малювання
class DrawPanel extends JPanel {
    private java.util.List<Shape> shapes = new ArrayList<>();
    public DrawPanel() {
        shapes.add(new Circle(50, 50, 100, Color.RED));
        shapes.add(new RectangleShape(200, 100, 120, 60, Color.BLUE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }
}

// Фрейм
public class DrawFrame extends JFrame {
    public DrawFrame() {
        setTitle("Draw Shapes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawPanel());
        setLocationRelativeTo(null); // центр на екрані
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawFrame::new);
    }
}
