package com.dsq.gui.basiceventhandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by DELL on 2017/7/2.
 */
public class MouseFrame extends JFrame {

    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }

    public static void main(String[] args){
        MouseFrame frame = new MouseFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class MouseComponent extends JComponent{

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MouseComponent() {
        this.squares = new ArrayList<>();
        this.current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(Rectangle2D r : squares){
            g2.draw(r);
        }
    }

    public Rectangle2D find(Point2D p){
        for(Rectangle2D r : squares){
            if(r.contains(p)){
                return r;
            }
        }
        return null;
    }

    public void add(Point2D p){
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s){
        if(s == null) return;
        if(s == current) current = null;
        squares.remove(s);
        repaint();
    }
    private class MouseHandler extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            current = find(e.getPoint());
            if(current == null){
                add(e.getPoint());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            current = find(e.getPoint());
            if(current != null  && e.getClickCount() >=2)
                remove(current);
        }

    }

    private class MouseMotionHandler implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(find(e.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
}

