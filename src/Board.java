
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class Board extends JPanel implements ActionListener {

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (currentCol + currentShape.getXmin() > 0) {
                        currentCol--;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (currentCol + currentShape.getXmax() < NUM_COLS - 1) {
                        currentCol++;
                    }
                    break;
                case KeyEvent.VK_UP:
                    currentRow--;
                    break;
                case KeyEvent.VK_DOWN:
                    currentRow++;
                    break;
                default:
                    break;
            }
            repaint();
        }
    }

    public static final int NUM_ROWS = 22;
    public static final int NUM_COLS = 10;

    private Tetrominoes[][] matrix;
    private int deltaTime;

    private Shape currentShape;

    private int currentCol;
    private int currentRow;

    private Timer timer;

    private MyKeyAdapter myKeyAdepter;

    public Board() {
        super();

        matrix = new Tetrominoes[NUM_ROWS][NUM_COLS];

        initValues();
        timer = new Timer(deltaTime, this);
    }

    public void initValues() {
        setFocusable(true);

        cleanBoard();

        deltaTime = 500;
        currentShape = null;

        currentRow = 0;
        currentCol = NUM_COLS / 2;

        myKeyAdepter = new MyKeyAdapter();

    }

    public void initGame() {
        initValues();
        timer.start();

        currentShape = new Shape(); // = Shape.getRandomShape()

        addKeyListener(myKeyAdepter);

    }

    public void cleanBoard() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {

                matrix[row][col] = Tetrominoes.NoShape;
            }
        }
    }

    //Main Game loop
    @Override
    public void actionPerformed(ActionEvent ae) {
        currentRow++;
        repaint(); //no se puede lamar directamente a paintComponent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawBoard(g);
        if (currentShape != null) {
            drawCurrentShape(g);
        }

    }

    private void drawSquare(Graphics g, int row, int col, Tetrominoes shape) {
        Color colors[] = {new Color(0, 0, 0),
            new Color(204, 102, 102),
            new Color(102, 204, 102), new Color(102, 102, 204),
            new Color(204, 204, 102), new Color(204, 102, 204),
            new Color(102, 204, 204), new Color(218, 170, 0)
        };

        int x = col * squareWidth();
        int y = row * squareHeight();
        Color color = colors[shape.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
    }

    private int squareWidth() {
        return getWidth() / NUM_COLS;
    }

    private int squareHeight() {
        return getHeight() / NUM_ROWS;
    }

    private void drawCurrentShape(Graphics g) {
        int[][] squaresArray = currentShape.getCoordinates();

        for (int point = 0; point <= 3; point++) {
            drawSquare(g, currentRow + squaresArray[point][1], currentCol + squaresArray[point][0], Tetrominoes.ZShape);
        }
    }

}
