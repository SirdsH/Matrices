package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetTraceMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_CalculateTraceSuccessfully() {
        // Create a 3x3 matrix
        double[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        IMatrix matrix = matrixFactory.create(data);

        // Calculate the expected trace value
        double expectedTrace = 15;

        // Calculate the trace of the matrix
        Number trace = matrix.getTrace();

        // Check the trace value without delta
        Assertions.assertEquals(expectedTrace, trace.intValue());
    }
}