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
            throw new NullPointerException("You haven't any discs for putting");
        }

        if (!peg.isEmpty() && peg.getFirst().getDiscNumber() < disc.getDiscNumber()) {
            throw new IllegalStateException("You can't put a disc with bigger discNumber " +
                    "on the disc with smaller discNumber");
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
            System.out.println(" don't contains any discs");
        } else {
            System.out.println(" contains following discs: " + peg);
        }
    }
}
