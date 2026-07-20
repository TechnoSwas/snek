import java.util.ArrayList;

// Snake handles the snake's body, movement, and collision detection
public class Snake {
    public ArrayList<int[]> body = new ArrayList<>(); // Each element is an {x, y} position
    public int dirX = 1; // Horizontal direction: -1 = left, 1 = right, 0 = none
    public int dirY = 0; // Vertical direction: -1 = up, 1 = down, 0 = none
    // Snake starts with 3 segments moving right
    public Snake() {
        body.add(new int[]{100, 100});
        body.add(new int[]{80, 100});
        body.add(new int[]{60, 100});

    }
    // Moves the snake by adding a new head and removing the tail
    public void move() {
        int headX = body.get(0)[0];
        int headY = body.get(0)[1];
        int newHeadX = headX + dirX * 20;
        int newHeadY = headY + dirY * 20;
        body.add(0, new int[]{newHeadX, newHeadY});
        body.remove(body.size() - 1);
    }
    // Grows the snake by duplicating the tail segment
    public void grow() {
        int[] tail = body.get(body.size() - 1);
        body.add(new int[]{tail[0], tail[1]});
    }
    // Returns true if the snake's head is outside the 500x500 grid
    public boolean hitWall() {
        int hx = body.get(0)[0];
        int hy = body.get(0)[1];
        return hx < 0 || hx >= 500 || hy < 0 || hy >= 500;
    }
    // Returns true if the snake's head overlaps any body segment
    public boolean hitSelf() {
        int hx = body.get(0)[0];
        int hy = body.get(0)[1];
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i)[0] == hx && body.get(i)[1] == hy) return true;
        }
        return false;
    }
}
