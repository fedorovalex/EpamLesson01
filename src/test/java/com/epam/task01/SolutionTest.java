package com.epam.task01;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.Math.abs;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testGetAmountSymbol() {
        Solution solution = new Solution();
        int testAmount = solution.getAmountSymbol("12012501540", '0');
        assertEquals(testAmount, 3);
    }

    @Test
    public void testIsRepeatLineInArray() {
        Solution solution = new Solution();
        String[] line = {"123", "456", "789", "123"};
        boolean isRepeatLine = solution.isRepeatLineInArray(line);
        assertEquals(isRepeatLine, true);
    }

    @Test
    public void testGetMatrixMultiplication() {
        Solution solution = new Solution();
        int[][] firstMatrix = {{1, 2, 0},
                               {2, 1, -1}};

        int[][] secondMatrix = {{1, 2, 3},
                                {3, 0, 2},
                                {4, 0, 1}};

        int[][] expectedResult = {{7, 2, 7},
                                  {1, 4, 7}};

        int[][] result = solution.multiplyMatrix(firstMatrix, secondMatrix);

        assertTrue(Arrays.deepEquals(result, expectedResult));
    }

    @Test
    public void testGetArraysIntersection() {
        Solution solution = new Solution();
        double epsilon = 0.000000001;
        double[] first = {1, 10/2, 6, 7.01};
        double[] second = {0, 5, 7.01, 17.5};
        double[] expectedIntersection = {5, 7.01};
        double[] intersection = solution.getArraysIntersection(first, second, epsilon);

        assertEquals(expectedIntersection.length, intersection.length);
        for (int i = 0; i < intersection.length; i++) {
            assertTrue(abs(expectedIntersection[i] - intersection[i]) < epsilon);
        }
    }
}

