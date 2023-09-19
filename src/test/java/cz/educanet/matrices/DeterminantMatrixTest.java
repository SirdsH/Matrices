package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterminantMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_CalculateDeterminantSuccessfully() {
        // Create a 3x3 matrix
        double[][] data = {
                {2, -3, 4},
                {1, 2, -2},
                {-3, 1, 2}
        };

        IMatrix matrix = matrixFactory.create(data);

        // Calculate the expected determinant value
        double expectedDeterminant = 28;

        // Calculate the determinant of the matrix
        double determinant = matrix.determinant();

        // Check the determinant value without delta
        Assertions.assertEquals(expectedDeterminant, determinant);
    }
}