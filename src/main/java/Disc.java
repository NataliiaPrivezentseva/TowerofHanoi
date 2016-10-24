public class Disc {
    private final int discNumber;

    public Disc(int discNumber) {
        this.discNumber = discNumber;
    }

    @Override
    public String toString() {
        return "Disc #" + discNumber;
    }
}
