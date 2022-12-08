import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static int size = 0;
    public static int diff = -1;
    public static Tile[] all;
    public static boolean flag = false;
    public static boolean mousePressed = false;
    public static void main(String[] args) {
        JFraming.createAndShowGUI();
        Timer waiter = new Timer("Until details are in");
        while (size < 1) {
            waiter.schedule(new TimerTask() {
                @Override
                public void run() {
                }
            }, 5);
        }
        System.out.println("Size: " + size + " by " + size + "\nDifficulty: " + diff);
        all = new Tile[size * size];
        //fill all
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                all[j + i * size] = new Tile(j, i);
            }
        }
        double mineToAllRatio;
        //determine ratio
        if (diff == 0) {
            mineToAllRatio = 10.0 / 81;
        } else if (diff == 1) {
            mineToAllRatio = 40.0 / 256;
        } else {
            mineToAllRatio = 99.0 / 480;
        }
        //make mines
        for (int i = 0; i < (int) (all.length * mineToAllRatio); i++) {
            int index = (int) (Math.random() * size * size);
            if (!all[index].mine) {
                all[index].mine = true;
            } else {
                i--;
            }
        }
        //sets values
        for (Tile t : all) {
            t.findVal();
        }
        Board.init();
        while (true) {
            if (StdDraw.isMousePressed() && !mousePressed) {
                mousePressed = true;
                click(StdDraw.mouseX, StdDraw.mouseY);
            } else if (!StdDraw.isMousePressed() && mousePressed) {
                mousePressed = false;
            } else if (mousePressed) {
            }

        }
    }
    public static void click(double x, double y){
        if (x > 1 && y > 1){
            flag = !flag;
            System.out.println(flag);
        } else {
            Tile temp = null;
            for (Tile t: all) {
                if (x * Main.size - t.coords[0] <= 1.0 && y * Main.size - t.coords[1] <= 1.0 ){
                   temp = t;
                   break;
                }
            }
            if (temp != null) {
                if (flag) {
                    temp.flagged = !temp.flagged;
                } else if (temp.flagged){
                    temp.flagged = false;
                } else {
                    temp.chain();
                }
            } else {
                System.out.println(" Click on a proper Tile motherFucker");
            }
        }
        Board.init();
    }
}