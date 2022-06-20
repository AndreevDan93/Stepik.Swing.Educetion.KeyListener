import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    static Main window = new Main();
    static int weight = 800;
    static int height = 600;
    static int imageSize = 50;
    static Image background;

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

    private static class Painting extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int x = 0; x <= weight - imageSize; x += imageSize) {
                for (int y = 0; y <= height - imageSize; y += imageSize) {
                    g.drawImage(background, x, y, null);

                }
            }

        }
    }


}