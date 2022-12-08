public class Tile {
    public boolean mine;
    public boolean revealed;
    public int[] coords = new int[2];
    public Tile(int x, int y){
        coords[0] = x;
        coords[1] = y;
        revealed = true;
    }
    public void draw(){
        if (mine && revealed) {
            StdDraw.filledCircle((coords[0] + 0.5) / Main.size, (coords[1] + 0.5) / Main.size, 0.25 / Main.size);
        }
    }
}
