import java.util.Deque;
import java.util.LinkedList;

public class Peg {
    private final Deque<Disc> peg;

    public Peg() {
        peg = new LinkedList<>();
    }

    public void putDisc(Disc disc) {
        peg.addFirst(disc);
    }

    public Disc takeDisc() {
        return peg.removeFirst();
    }

    public void printPegState() {
        if (peg.isEmpty()) {
            System.out.println(" don't contains any discs");
        } else {
            System.out.println(" contains following discs: " + peg);
        }
    }
}
