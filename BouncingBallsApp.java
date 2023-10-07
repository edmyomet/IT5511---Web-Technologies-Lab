import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class BouncingBallsApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        BouncingBallsPanel panel = new BouncingBallsPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}

class BouncingBallsPanel extends JPanel implements Runnable {
    private final int BALL_SIZE = 30;
    private ArrayList<Ball> balls = new ArrayList<>();

    public BouncingBallsPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (balls.size() < 20) { // Limit the number of balls
                    Color randomColor = generateRandomColor();
                    balls.add(new Ball(e.getX(), e.getY(), BALL_SIZE, randomColor));
                    Thread thread = new Thread(BouncingBallsPanel.this);
                    thread.start();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw balls
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    @Override
    public void run() {
        while (!balls.isEmpty()) {
            for (int i = 0; i < balls.size(); i++) {
                Ball ball = balls.get(i);
                ball.move(getWidth(), getHeight());

                // Check for collision with the edge and reverse direction
                if (ball.getX() <= 0 || ball.getX() >= getWidth() - BALL_SIZE) {
                    ball.reverseXDirection();
                }
                if (ball.getY() <= 0 || ball.getY() >= getHeight() - BALL_SIZE) {
                    ball.reverseYDirection();
                }

                // Repaint the panel
                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Color generateRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}

class Ball {
    private int x;
    private int y;
    private int size;
    private Color color;
    private int xDirection = 1;
    private int yDirection = 1;

    public Ball(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void move(int panelWidth, int panelHeight) {
        x += 2 * xDirection;
        y += 2 * yDirection;

        // Implement logic to increase/decrease size and draw shadows here (3D effect)
    }

    public void reverseXDirection() {
        xDirection *= -1;
    }

    public void reverseYDirection() {
        yDirection *= -1;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);

        // Implement drawing shadows here
        g.setColor(Color.BLACK);
        g.fillOval(x + size / 4, y + size * 3 / 4, size / 2, size / 4);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
