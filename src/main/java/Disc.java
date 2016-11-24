class Disc {
    private final int discNumber;

    Disc(int discNumber) {
        if (discNumber <= 0) {
            throw new IllegalArgumentException("Disc number can't be zero or negative integer");
        } else {
            this.discNumber = discNumber;
        }
    }

    int getDiscNumber() {
        return discNumber;
    }

    @Override
    public String toString() {
        return "Disc #" + discNumber;
    }
}
