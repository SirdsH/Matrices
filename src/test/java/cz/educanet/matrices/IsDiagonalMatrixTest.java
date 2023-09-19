package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsDiagonalMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_RecognizeDiagonalMatrix() {
        // Create a diagonal matrix (3x3)
        double[][] diagonalData = {
                {1, 0, 0},
                {0, 2, 0},
                {0, 0, 3}
        };

        IMatrix diagonalMatrix = matrixFactory.create(diagonalData);

        // Check if the matrix is a diagonal matrix
        boolean isDiagonal = diagonalMatrix.isDiagonal();

        // The matrix is diagonal, so the result should be true
        Assertions.assertTrue(isDiagonal);
    }

    @Test
    public void should_RecognizeNonDiagonalMatrix() {
        // Create a non-diagonal matrix (3x3)
        double[][] nonDiagonalData = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        IMatrix nonDiagonalMatrix = matrixFactory.create(nonDiagonalData);

        // Check if the matrix is a diagonal matrix
        boolean isDiagonal = nonDiagonalMatrix.isDiagonal();

        // The matrix is not diagonal, so the result should be false
        Assertions.assertFalse(isDiagonal);
    }
}