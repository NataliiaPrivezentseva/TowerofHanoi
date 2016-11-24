class Disc {
    private final int discNumber;

    Disc(int discNumber) {
        this.discNumber = discNumber;
    }

    int getDiscNumber() {
        return discNumber;
    }

    @Override
    public String toString() {
        return "Disc #" + discNumber;
    }
}
