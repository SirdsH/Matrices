package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixFactoryTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_CreateMatrixWithValidData() {
        double[][] data = {
                {1, 2},
                {3, 4}
        };

        IMatrix matrix = matrixFactory.create(data);

        Assertions.assertEquals(2, matrix.getRows());
        Assertions.assertEquals(2, matrix.getColumns());
        Assertions.assertEquals(1, matrix.get(0, 0));
        Assertions.assertEquals(2, matrix.get(0, 1));
        Assertions.assertEquals(3, matrix.get(1, 0));
        Assertions.assertEquals(4, matrix.get(1, 1));
    }

    @Test
    public void should_CreateDiagonalMatrixWithValidDiagonal() {
        double[] diagonal = {1, 2, 3};

        IMatrix matrix = matrixFactory.createDiagonal(diagonal);

        Assertions.assertEquals(3, matrix.getRows());
        Assertions.assertEquals(3, matrix.getColumns());
        Assertions.assertEquals(1, matrix.get(0, 0));
        Assertions.assertEquals(2, matrix.get(1, 1));
        Assertions.assertEquals(3, matrix.get(2, 2));
    }

    @Test
    public void should_CreateIdentityMatrixWithValidSize() {
        int size = 4;

        IMatrix matrix = matrixFactory.createIdentity(size);

        Assertions.assertEquals(size, matrix.getRows());
        Assertions.assertEquals(size, matrix.getColumns());
        Assertions.assertEquals(1, matrix.get(0, 0));
        Assertions.assertEquals(1, matrix.get(1, 1));
        Assertions.assertEquals(1, matrix.get(2, 2));
        Assertions.assertEquals(1, matrix.get(3, 3));
        Assertions.assertEquals(0, matrix.get(1, 0));
        Assertions.assertEquals(0, matrix.get(2, 1));
    }

    @Test
    public void should_CreateZeroMatrixWithValidSize() {
        int size = 3;

        IMatrix matrix = matrixFactory.createZero(size);

        Assertions.assertEquals(size, matrix.getRows());
        Assertions.assertEquals(size, matrix.getColumns());

        for (int n = 0; n < size; n++) {
            for (int m = 0; m < size; m++) {
                Assertions.assertEquals(0, matrix.get(n, m));
            }
        }
    }
}
