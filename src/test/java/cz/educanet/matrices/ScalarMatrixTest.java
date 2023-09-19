package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScalarMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_MultiplyMatrixByScalar_Successfully() {
        // Create a matrix
        double[][] data = {
                {1, 2},
                {3, 4}
        };

        IMatrix matrix = matrixFactory.create(data);

        // Define the scalar value
        Number scalar = 2;

        // Calculate the expected result
        double[][] expectedResult = {
                {2, 4},
                {6, 8}
        };

        // Multiply the matrix by the scalar
        IMatrix resultMatrix = matrix.times(scalar);

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