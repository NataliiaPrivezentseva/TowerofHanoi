import java.util.Deque;
import java.util.LinkedList;

class Peg {
    private final Deque<Disc> peg;

    Peg() {
        peg = new LinkedList<>();
    }

    void putDisc(Disc disc) {
        peg.addFirst(disc);
    }

    Disc takeDisc() {
        if (peg.isEmpty()) {
            throw new NullPointerException();
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
