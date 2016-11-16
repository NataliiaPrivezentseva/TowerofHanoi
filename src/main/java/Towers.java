import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Towers {

    public static void main(String[] args) {
        int towerHeight = getTowerHeight();
        List<Peg> threePegs = createThreePegs();
        createTower(threePegs, towerHeight);
        printTowerState(threePegs);
        moveTower(threePegs, towerHeight, threePegs.get(0), threePegs.get(2), threePegs.get(1));
    }

    private static int getTowerHeight(){
        int towerHeight;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Please, enter the height of the tower. It must be positive integer");

            while (!input.hasNextInt()) {
                String usersInput = input.next();
                System.out.println(usersInput + " — improper value of the height of the tower. " +
                        "Please, enter the proper height of the tower");
            }
            towerHeight = input.nextInt();

        } while (towerHeight <= 0);

        return towerHeight;
    }

    private static void moveTower(List<Peg> threePegs, int towerHeight, Peg from, Peg to, Peg tmp) {
        if (from.equals(to) || from.equals(tmp)) {
            throw new IllegalArgumentException("You can't move a tower to the peg, where it is");
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

    private static void moveDisc(Peg from, Peg to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("You can't move a disc to the peg, where it is");
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
            throw new IllegalArgumentException("You can't create a tower with negative number of discs or without any discs");
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

