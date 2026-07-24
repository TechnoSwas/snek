import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Timer;
import java.awt.event.ActionListener;   // I had to import a few things for the game to work
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
// GamePanel is the main game class — it handles drawing, game logic, and keyboard input
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Snake snake = new Snake();       // The snake object
    Food food = new Food();             // The food object
    int gameScore = 0;                  // Tracks the current score
    boolean gameOver = false;           // Flips to true when the player dies
    Timer timer = new Timer(150, this); // Calls actionPerformed every 150ms (game speed)
    // Constructor — sets up the window, starts the timer, and enables keyboard input
    public GamePanel() {
        setBackground(new Color(170, 215, 81));
        setPreferredSize(new Dimension(500, 500));
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }
    // Called every 150ms by the timer — this is the game loop
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.move(); // Move the snake one step
            // Check if the snake's head is on the food (Adds 1 to the score)
            if (snake.body.get(0)[0] == food.x && snake.body.get(0)[1] == food.y) {
                snake.grow();
                food.respawn();
                gameScore++;
            }
            // Check for death conditions
            if (snake.hitWall() || snake.hitSelf()) {
                gameOver = true;
            }
            repaint();

        }

    }
    @Override
    // paintComponent is called every time repaint() is triggered — draws everything
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over, click R to play again.", 150, 250); //Draws text at specific coordinates
            g.drawString("Final Score " + gameScore, 200, 270); //Draws text at specific coordinates
            return;
        }
        // Draw the grid lines
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < 500; i += 20) {
            g.drawLine(i, 0, i, 500); // Vertical lines
        }
        for (int i = 0; i < 500; i += 20) {
            g.drawLine(0, i, 500, i); // Horizontal lines
        }
        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, 20, 20);
        for (int i = 0; i < snake.body.size(); i++) {
              g.setColor(new Color(23, 50, 3));
              g.fillRect(snake.body.get(i)[0], snake.body.get(i)[1], 20, 20);
        }
        g.drawString("Score: " + gameScore, 10,20);
    }
    public void keyTyped(KeyEvent e) {}   // Required by KeyListener but unused
    public void keyReleased(KeyEvent e) {} // Required by KeyListener but unused
    // keyPressed handles all player input
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
        // R key resets the game
        if (e.getKeyCode() == KeyEvent.VK_R) {
            snake = new Snake();
            food = new Food();
            gameScore = 0;
            gameOver = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.dirX = 0;
            snake.dirY = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.dirX = 0;
            snake.dirY = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.dirX = 1;
            snake.dirY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.dirX = -1;
            snake.dirY = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            snake.dirX = 0;
            snake.dirY = -1;

        }
    }
}
