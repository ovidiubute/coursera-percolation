import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n > 0");
        }

        this.n = n;
    }

    public void open(int row, int col) {
        assertIndexes(row, col);
    }

    public boolean isOpen(int row, int col) {
        assertIndexes(row, col);
    }

    public boolean isFull(int row, int col) {
        assertIndexes(row, col);
    }

    public int numberOfOpenSites() {
        return 0;
    }

    public boolean percolates() {
        return false;
    }

    private void assertIndexes(int row, int col) {
        if (row <= 0 || col <= 0 || row > n || col > n) {
            throw new IndexOutOfBoundsException("1 <= row <= n & 1 <= col <= n");
        }
    }

    public static void main(String[] args) {

    }
}
