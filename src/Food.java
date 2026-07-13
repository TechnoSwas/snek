import java.util.Random;

public class Food {
    public int x;
    public int y;
    private Random random = new Random();

    public Food() {
        respawn();
    }

    public void respawn() {
        x = random.nextInt(25) * 20;
        y = random.nextInt(25) * 20;
    }
}