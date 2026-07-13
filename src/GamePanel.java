import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Timer;
import java.awt.event.ActionListener;                   // I had to import a few things for the game to work
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Snake snake = new Snake();
    Food food = new Food();
    boolean gameOver = false;
    Timer timer = new Timer(150, this);
    public GamePanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(500, 500));
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.move();
            if (snake.body.get(0)[0] == food.x && snake.body.get(0)[1] == food.y) {
                snake.grow();
                food.respawn();
            }
            if (snake.hitWall() || snake.hitSelf()) {
                gameOver = true;
            }
            repaint();

        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over", 200, 250);
            return;
        }
        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, 20, 20);
        for (int i = 0; i < snake.body.size(); i++) {
              g.setColor(Color.GREEN);
              g.fillRect(snake.body.get(i)[0], snake.body.get(i)[1], 20, 20);
        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {if (e.getKeyCode() == KeyEvent.VK_W) {
        snake.dirX = 0;
        snake.dirY = -1;
    }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            snake.dirX = 0;
            snake.dirY = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            snake.dirX = -1;
            snake.dirY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            snake.dirX = 1;
            snake.dirY = 0;
        }
    }
}
