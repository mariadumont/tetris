
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class NextShape extends JPanel {

    private Shape shape;

    public NextShape() {
        shape = Shape.getRandomShape();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (shape != null) {
            shape.draw(g, 1, 1, squareWidth(), squareHeight());

        }
    }

    private int squareWidth() {
        return getWidth() / 4;
    }

    private int squareHeight() {
        return getHeight() / 4;
    }

    public Shape getShape() {
        return shape;
    }

    public void generateNewShape() {
        shape = Shape.getRandomShape();
        repaint();
    }

}
