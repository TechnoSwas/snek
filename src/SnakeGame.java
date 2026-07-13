import javax.swing.JFrame;
public class SnakeGame {
    public static void main(String[] args) {
        JFrame window = new JFrame("Snek");
        GamePanel panel = new GamePanel();
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}