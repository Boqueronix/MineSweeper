import java.awt.*;

public class Board {
    public static void init(){
        StdDraw.clear();
        StdDraw.setScale(0,(Main.size + 1.0)/Main.size);
        StdDraw.setPenColor(Color.BLACK);
        for (int i = 0; i < Main.size + 1; i++) {
            StdDraw.line(i / (double) Main.size, 0, i / (double) Main.size, 1);
            StdDraw.line(0, i / (double) Main.size, 1, i / (double) Main.size);
        }
        for (Tile t: Main.all) {
            t.draw();
        }
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(1 + 1.0 / (2 * Main.size), 1 + 1.0 / (2 * Main.size), 1.0 / (2 * Main.size));
        if (Main.flag) {
            StdDraw.setPenRadius(0.005);
            StdDraw.square(1 + 1.0 / (2 * Main.size), 1 + 1.0 / (2 * Main.size), 1.0 / (2 * Main.size));
        }
        StdDraw.setPenRadius();
    }
}
