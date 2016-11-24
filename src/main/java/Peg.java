import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class Peg {
    private final Deque<Disc> discs;

    Peg() {
        discs = new LinkedList<>();
    }

    void putDisc(Disc disc) {
        if (disc == null) {
            throw new NullPointerException("You haven't any discs for putting");
        }

        if (!discs.isEmpty() && discs.getFirst().getDiscNumber() < disc.getDiscNumber()) {
            throw new IllegalStateException("You can't put a disc with bigger discNumber " +
                    "on the disc with smaller discNumber");
        }

        discs.addFirst(disc);
    }

    Disc takeDisc() {
        if (discs.isEmpty()) {
            throw new NoSuchElementException("You can't take a disk from an empty peg");
        }
        return discs.removeFirst();
    }

    void printPegState() {
        if (discs.isEmpty()) {
            System.out.println(" don't contains any discs");
        } else {
            System.out.println(" contains following discs: " + discs);
        }
    }
}
