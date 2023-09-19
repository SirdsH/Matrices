package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSquareMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_RecognizeSquareMatrix() {
        // Create a square matrix (4x4)
        double[][] squareData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        IMatrix squareMatrix = matrixFactory.create(squareData);

        // Check if the matrix is square
        boolean isSquare = squareMatrix.isSquare();

        // The matrix is square, so the result should be true
        Assertions.assertTrue(isSquare);
    }

    @Test
    public void should_RecognizeNonSquareMatrix() {
        // Create a non-square matrix (3x2)
        double[][] nonSquareData = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        IMatrix nonSquareMatrix = matrixFactory.create(nonSquareData);

        // Check if the matrix is square
        boolean isSquare = nonSquareMatrix.isSquare();

        // The matrix is not square, so the result should be false
        Assertions.assertFalse(isSquare);
    }
}