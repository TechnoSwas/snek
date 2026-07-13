import java.util.ArrayList;
public class Snake {
    public ArrayList<int[]> body = new ArrayList<>();
    public int dirX = 1;
    public int dirY = 0;
    public Snake() {
        body.add(new int[]{100, 100});
        body.add(new int[]{80, 100});
        body.add(new int[]{60, 100});

    }
    public void move() {
        int headX = body.get(0)[0];
        int headY = body.get(0)[1];
        int newHeadX = headX + dirX * 20;
        int newHeadY = headY + dirY * 20;
        body.add(0, new int[]{newHeadX, newHeadY});
        body.remove(body.size() - 1);
    }
    public void grow() {
        int[] tail = body.get(body.size() - 1);
        body.add(new int[]{tail[0], tail[1]});
    }
    public boolean hitWall() {
        int hx = body.get(0)[0];
        int hy = body.get(0)[1];
        return hx < 0 || hx >= 500 || hy < 0 || hy >= 500;
    }
    public boolean hitSelf() {
        int hx = body.get(0)[0];
        int hy = body.get(0)[1];
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i)[0] == hx && body.get(i)[1] == hy) return true;
        }
        return false;
    }
}
