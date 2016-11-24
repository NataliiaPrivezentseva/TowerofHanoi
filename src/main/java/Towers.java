import java.util.ArrayList;
import java.util.List;

class Towers {

    static void moveTower(List<Peg> threePegs, int towerHeight, Peg from, Peg to, Peg tmp) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("You can't move a tower to the peg, where it is");
        }
        if (from.equals(tmp) || to.equals(tmp)) {
            throw new IllegalArgumentException("You can't move a tower without tmp peg");
        }

        if (towerHeight == 1) {
            moveDisc(from, to);
            printTowerState(threePegs);
        } else {
            moveTower(threePegs, towerHeight - 1, from, tmp, to);
            moveDisc(from, to);
            printTowerState(threePegs);
            moveTower(threePegs, towerHeight - 1, tmp, to, from);
        }
    }

    // can I test throwing Exception from private method? - Yes, through public (moveTower) method...
    private static void moveDisc(Peg from, Peg to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("You can't move a disc to the peg, where it is");
        }

        Disc disc = from.takeDisc();
        to.putDisc(disc);
    }

    // don't test because it is output to console
    static void printTowerState(List<Peg> threePegs) {
        for (int i = 0; i < threePegs.size(); i++) {
            System.out.print("Peg #" + i);
            threePegs.get(i).printPegState();
        }
        System.out.println();
    }

    // COVERED BY UNIT TESTS
    static List<Peg> createTower(int towerHeight) {
        List<Peg> threePegs = createThreePegs();
        if (towerHeight <= 0) {
            throw new IllegalArgumentException("You can't create a tower with negative number of discs or without any discs");
        }
        for (int i = towerHeight; i > 0; i--) {
            threePegs.get(0).putDisc(new Disc(i));
        }
        return threePegs;
    }

    // WAS TESTED INDIRECT IN createTower METHOD
    private static List<Peg> createThreePegs() {
        List<Peg> threePegs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            threePegs.add(new Peg());
        }
        return threePegs;
    }

}

