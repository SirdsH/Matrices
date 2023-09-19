package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimesMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_MultiplyMatrices_Successfully() {
        // Create two matrices
        double[][] data1 = {
                {1, 2},
                {3, 4}
        };

        double[][] data2 = {
                {5, 6},
                {7, 8}
        };

        IMatrix matrix1 = matrixFactory.create(data1);
        IMatrix matrix2 = matrixFactory.create(data2);

        // Calculate the expected result
        double[][] expectedResult = {
                {19, 22},
                {43, 50}
        };

        // Multiply the matrices
        IMatrix resultMatrix = matrix1.times(matrix2);

        // Check dimensions
        Assertions.assertEquals(2, resultMatrix.getRows());
        Assertions.assertEquals(2, resultMatrix.getColumns());

        // Check the elements of the resulting matrix
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assertions.assertEquals(expectedResult[i][j], resultMatrix.get(i, j));
            }
        }
    }
}