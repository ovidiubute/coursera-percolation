import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int[] grid;
    private int opened;
    private WeightedQuickUnionUF uf;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n > 0");
        }

        this.n = n;
        this.uf = new WeightedQuickUnionUF(n + 2);
        this.grid = new int[n];
        for (int i = 0; i < n; i++) {
            grid[i] = 0;
        }
    }

    public void open(int row, int col) {
        assertIndexes(row, col);

        final int index = get1d(row, col);
        grid[index] = 1;
        opened++;
        if (row == 1 && !uf.connected(0, index)) {
            uf.union(0, index);
        }
        if (row == n && !uf.connected(n + 1, index)) {
            uf.union(index, n + 1);
        }
        connectNeighbours(row, col);
    }

    public boolean isOpen(int row, int col) {
        assertIndexes(row, col);

        return (grid[get1d(row, col)] == 1);
    }

    public boolean isFull(int row, int col) {
        assertIndexes(row, col);

        return (opened == row * col);
    }

    public int numberOfOpenSites() {
        return opened;
    }

    public boolean percolates() {
        return (this.uf.count() == 1);
    }

    private void connectNeighbours(int row, int col) {
        int rowUp = row - 1;
        int rowDown = row + 1;
        int colLeft = col - 1;
        int colRight = col + 1;
        int curIndex = get1d(row, col);

        if (rowUp > 0) {
            int index = get1d(rowUp, col);
            if (grid[index] == 1) {
                 uf.union(index, curIndex);
            }
        }

        if (rowDown <= n) {
            int index = get1d(rowDown, col);
            if (grid[index] == 1) {
                uf.union(index, curIndex);
            }
        }

        if (colLeft > 0) {
            int index = get1d(row, colLeft);
            if (grid[index] == 1) {
                uf.union(index, curIndex);
            }
        }

        if (colRight <= n) {
            int index = get1d(row, colRight);
            if (grid[index] == 1) {
                uf.union(index, curIndex);
            }
        }
    }

    private int get1d(int row, int col) {
        return row * col - 1;
    }

    private void assertIndexes(int row, int col) {
        if (row <= 0 || col <= 0 || row > n || col > n) {
            throw new IndexOutOfBoundsException("1 <= row <= n & 1 <= col <= n");
        }
    }

    public static void main(String[] args) {

    }
}
