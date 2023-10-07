import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollingBallApp extends JFrame {
    private int ballX = -30;
    private int ballY = -30;
    private Timer timer;

    public RollingBallApp() {
        setTitle("Rolling Ball App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ballX = evt.getX();
                ballY = evt.getY();
                startAnimation();
            }
        });

        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ballX += 5; // Move the ball to the right
                repaint();
                if (ballX > getWidth()) {
                    stopAnimation();
                }
            }
        });
    }

    private void startAnimation() {
        timer.start();
    }

    private void stopAnimation() {
        timer.stop();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(ballX, ballY, 30, 30);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RollingBallApp().setVisible(true);
            }
        });
    }
}
