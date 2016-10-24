import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Towers {

    public static void main(String[] args) {
        int towerHeight;
        System.out.println("Please, enter the height of the tower");
        Scanner input = new Scanner(System.in);
        towerHeight = input.nextInt();

        List<Peg> threePegs = createThreePegs();
        createTower(threePegs, towerHeight);
        printTowerState(threePegs);

        moveTower(threePegs, towerHeight, threePegs.get(0), threePegs.get(2), threePegs.get(1));
    }

    private static void moveTower(List<Peg> threePegs, int towerHeight, Peg from, Peg to, Peg tmp) {
        if (from.equals(to) || from.equals(tmp)) {
            throw new IllegalArgumentException();
        }
        if (towerHeight == 1) {
            moveDisk(from, to);
            printTowerState(threePegs);
        } else {
            moveTower(threePegs, towerHeight - 1, from, tmp, to);
            moveDisk(from, to);
            printTowerState(threePegs);
            moveTower(threePegs, towerHeight - 1, tmp, to, from);
        }
    }

    private static void moveDisk(Peg from, Peg to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException();
        }
        Disc disc = from.takeDisc();
        to.putDisc(disc);
    }

    private static void printTowerState(List<Peg> threePegs) {
        for (int i = 0; i < threePegs.size(); i++) {
            System.out.print("Peg #" + i);
            threePegs.get(i).printPegState();
        }
        System.out.println();
    }

    private static void createTower(List<Peg> threePegs, int towerHeight) {
        if (towerHeight <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = towerHeight; i > 0; i--) {
            threePegs.get(0).putDisc(new Disc(i));
        }
    }

    private static List<Peg> createThreePegs() {
        List<Peg> threePegs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            threePegs.add(new Peg());
        }
        return threePegs;
    }
}

