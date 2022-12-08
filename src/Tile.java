import java.awt.*;

public class Tile {
    public boolean mine;
    public boolean revealed;
    public int[] coords = new int[2];
    public int val;
    public boolean flagged;
    public Tile(int x, int y){
        coords[0] = x;
        coords[1] = y;
        revealed = false;
        flagged = false;
    }
    public void draw(){
        if (revealed) {
            StdDraw.setPenColor(Color.BLACK);
            if (mine) {
                StdDraw.filledCircle((coords[0] + 0.5) / Main.size, (coords[1] + 0.5) / Main.size, 0.25 / Main.size);
            } else {
                StdDraw.setFont(new Font("Sans Serif", Font.PLAIN, 200 / Main.size));
                StdDraw.text((coords[0] + 0.5) / Main.size, (coords[1] + 0.5) / Main.size, "" + val);

            }
        } else if (flagged){
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledCircle((coords[0] + 0.5) / Main.size, (coords[1] + 0.5) / Main.size, 0.25 / Main.size);
        }
    }
    public void findVal(){
        int count = 0;
        for (Tile t: Main.all) {
            if (Math.abs (t.coords[0] - coords[0]) < 2 && Math.abs(t.coords[1] - coords[1]) < 2 && t.mine && !t.equals(this)){
                count++;
            }
        }
        val = count;
    }
    public void chain(){
        revealed = true;
        if (val == 0){
            for (Tile t: Main.all) {
                if (Math.abs (t.coords[0] - coords[0]) < 2 && Math.abs(t.coords[1] - coords[1]) < 2 && !t.revealed){
                    t.chain();
                }
            }
        }
    }
}
