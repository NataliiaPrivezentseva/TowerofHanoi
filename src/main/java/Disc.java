class Disc {
    private final int discNumber;

    Disc(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    @Override
    public String toString() {
        return "Disc #" + discNumber;
    }
}
