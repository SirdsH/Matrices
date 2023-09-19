package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranposeMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_TransposeMatrix_Successfully() {
        // Create a matrix
        double[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        IMatrix matrix = matrixFactory.create(data);

        // Calculate the expected result after transposing
        double[][] expectedResult = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        // Transpose the matrix
        IMatrix transposedMatrix = matrix.transpose();

        // Check dimensions
        Assertions.assertEquals(3, transposedMatrix.getRows());
        Assertions.assertEquals(3, transposedMatrix.getColumns());

        // Check the elements of the transposed matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Assertions.assertEquals(expectedResult[i][j], transposedMatrix.get(i, j));
            }
        }
    }
}