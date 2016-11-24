import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class Peg {
    private final Deque<Disc> peg;

    Peg() {
        peg = new LinkedList<>();
    }

    void putDisc(Disc disc) {
        if (disc == null) {
            throw new NullPointerException("You haven't any peg for putting");
        }

        if (!peg.isEmpty() && peg.getFirst().getDiscNumber() <= disc.getDiscNumber()) {
            throw new IllegalStateException("You can't put a disc with bigger discNumber " +
                    "on the disc with smaller discNumber. Also you can't put disc on the" +
                    "disc with the same discNumber");
        }

        peg.addFirst(disc);
    }

    Disc takeDisc() {
        if (peg.isEmpty()) {
            throw new NoSuchElementException("You can't take a disk from an empty peg");
        }
        return peg.removeFirst();
    }

    void printPegState() {
        if (peg.isEmpty()) {
            System.out.println(" don't contains any peg");
        } else {
            System.out.println(" contains following peg: " + peg);
        }
    }
}
