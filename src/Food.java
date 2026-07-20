import java.util.Random;

// Food handles the food's position and respawning
public class Food {
    public int x; // x position of the food
    public int y; // y position of the food
    private Random random = new Random(); // Used to pick a random grid position

    public Food() {
        respawn();
    }

    // Places the food at a random position on the 25x20 grid
    public void respawn() {
        x = random.nextInt(25) * 20;
        y = random.nextInt(25) * 20;
    }
}