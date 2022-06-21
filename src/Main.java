import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame implements KeyListener, MouseListener, MouseWheelListener {
    static Main window = new Main();
    static int backgroundX = 0;
    static int backgroundY = 0;
    static int weight = 800;
    static int height = 600;
    static int imageSize = 50;
    static Image background;

    public Main() {
        addKeyListener(this);
        addMouseListener(this);
        addMouseWheelListener(this);
    }

    public static void main(String[] args) throws IOException {
        initFrame();
        background = ImageIO.read(Main.class.getResourceAsStream("background.jpg"));
        Painting painting = new Painting();
        window.add(painting);

        window.setVisible(true);


    }

    static void initFrame() {
        window.pack();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setBounds(0, 0, weight, height);
        window.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int imageV;
        if (e.isShiftDown()) imageV = 5 * imageSize;
        else imageV = imageSize;


        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                if (backgroundX > 0)
                    backgroundX = backgroundX - imageV;
                else backgroundX = weight;
                break;
            case KeyEvent.VK_D:
                if (backgroundX < weight - imageSize)
                    backgroundX = backgroundX + imageV;
                else backgroundX = 0;
                break;
            case KeyEvent.VK_W:
                if (backgroundY > 0)
                    backgroundY = backgroundY - imageV;
                else backgroundY = height;
                break;
            case KeyEvent.VK_S:
                if (backgroundY < height - imageSize)
                    backgroundY = backgroundY + imageV;
                else backgroundY = 0;
                break;



        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        backgroundX = x;
        backgroundY = y;


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.isAltDown())
            backgroundY = backgroundX + imageSize;


    }


    private static class Painting extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(background, backgroundX, backgroundY, null);
            repaint();


        }
    }


}