package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix times(IMatrix matrix) {
        double[][] data = new double[this.getRows()][matrix.getColumns()];

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < this.getColumns(); k++) {
                    data[i][j] += this.get(i, k) * matrix.get(k, j);
                }
            }
        }
        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix times(Number scalar) {
        double[][] data = new double[this.getRows()][this.getColumns()];

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                data[i][j] = this.get(i, j) * scalar.doubleValue();
            }
        }

        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] data = new double[this.getRows()][this.getColumns()];

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                data[i][j] = this.get(i, j) + matrix.get(i, j);
            }
        }
        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix transpose() {
        double[][] data = new double[this.getColumns()][this.getRows()];

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                data[j][i] = this.get(i, j);
            }
        }
        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        if (!isSquare()) {
            throw new IllegalArgumentException("It needs a square idk.");
        }

        if (getRows() == 1) {
            return rawArray[0][0];
        }
        double raw_WWA_champion = 0;

        for (int i = 0; i < this.getColumns(); i++) {
            if (i % 2 == 0) {
                raw_WWA_champion += rawArray[0][i] * underMatrix(i).determinant();
            } else raw_WWA_champion -= rawArray[0][i] * underMatrix(i).determinant();
        }

        return raw_WWA_champion;
    }

    private IMatrix underMatrix(int xy) {
        double[][] data = new double[this.getRows() - 1][this.getColumns() - 1];

        for (int i = 1; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (j != xy) {
                    if (j < xy) {
                        data[i - 1][j] = rawArray[i][j];
                    } else data[i - 1][j - 1] = rawArray[i][j];
                }
            }
        }

        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public boolean isSquare() {
        return this.getRows() == this.getColumns();
    }

    /**
     * TODO: Implement
     */
    @Override
    public boolean isDiagonal() {
        if (!isSquare()) {
            return false;
        }

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (i != j && rawArray[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * TODO: Implement
     */
    @Override
    public Number getTrace() {
        if (!isSquare()) {
            throw new IllegalArgumentException("Its need a square idk.");
        }

        double trace = 0;
        for (int i = 0; i < this.getRows(); i++) {
            trace += rawArray[i][i];
        }
        return trace;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
