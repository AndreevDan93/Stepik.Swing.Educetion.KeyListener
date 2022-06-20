import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame implements KeyListener {
    static Main window = new Main();
    static int backgroundX = 0;
    static int backgroundY = 0;
    static int weight = 800;
    static int height = 600;
    static int imageSize = 50;
    static Image background;

    public Main (){
        addKeyListener(this);
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
        switch (e.getKeyCode()) {
            case  KeyEvent.VK_A:
                backgroundX = backgroundX - imageSize;
                break;
            case KeyEvent.VK_D:
                backgroundX = backgroundX + imageSize;
                break;
            case KeyEvent.VK_W:
                backgroundY = backgroundY - imageSize;
                break;
            case KeyEvent.VK_S:
                backgroundY = backgroundY + imageSize;
                break;


        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

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