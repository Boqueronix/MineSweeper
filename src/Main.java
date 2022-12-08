import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static int size = 0;
    public static int diff = -1;
    public static Tile[] all;
    public static void main(String[] args) {
        JFraming.createAndShowGUI();
        Timer waiter = new Timer("Until details are in");
        while (size < 1){
            waiter.schedule(new TimerTask() {
                @Override
                public void run() {

                }
            }, 5);
        }
        System.out.println("Size: " + size  + " by " + size + "\nDifficulty: " + diff);
        all = new Tile[size * size];
        //fill all
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                all[j + i * size] = new Tile(j, i);
            }
        }
        double mineToAllRatio;
        //determine ratio
        if (diff == 0){
            mineToAllRatio = 10.0 / 81;
        } else if (diff == 1) {
            mineToAllRatio = 40.0 / 256;
        } else {
            mineToAllRatio = 99.0 / 480;
        }
        for (int i = 0; i < (int) (all.length * mineToAllRatio); i++) {
            int index = (int) (Math.random() * size * size);
            if (!all[index].mine) {
                all[index].mine = true;
            } else {
                i--;
            }
        }
        Board.init();

    }
}