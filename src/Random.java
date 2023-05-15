public class Random {
    private int lowerBound;
    private int upperBound;

    public Random(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getRandomNumber() {
        java.util.Random rand = new java.util.Random();
        return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}