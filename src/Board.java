public class Board {
    public static void init(){
        for (int i = 0; i < Main.size + 1; i++) {
            StdDraw.line(i / (double) Main.size, 0, i / (double) Main.size, 1);
            StdDraw.line(0, i / (double) Main.size, 1, i / (double) Main.size);
            for (Tile t: Main.all) {
                t.draw();
            }
        }
    }
}
