package com.epam.task01;


import static java.lang.Math.abs;

/**
 * Решение первого задания.
 */
public class Solution {

    public int getAmountSymbol(String line, char symbol) {
        return line.length() - line.replace(String.valueOf(symbol), "").length();
    }

    public boolean isRepeatLineInArray(String[] lines) {

        boolean isRepeat = false;

        for (int i = 0; !isRepeat && i < lines.length; i++) {
            String str = lines[i];
            for (int j = i + 1; j < lines.length; j++) {
                if (str.equals(lines[j])) {
                    isRepeat = true;
                    break;
                }
            }
        }
        return isRepeat;
    }

    public int[][] multiplyMatrix (int[][] left, int[][] right) {

        if (!checkMatrix(left) || !checkMatrix(right)) {
            throw new IllegalArgumentException("Матрицы не прямоугольные.");
        }

        if (getColumnCount(left) != getRowCount(right)) {
            throw new IllegalArgumentException("Умножение не определено.");
        }

        int[][] result = new int[getRowCount(left)][getColumnCount(right)];
        for (int rowNumber = 0; rowNumber < getRowCount(left); rowNumber++) {
            for (int columnNumber = 0; columnNumber < getColumnCount(right); columnNumber++) {
                result[rowNumber][columnNumber] = multiplyVector(getRow(left, rowNumber), getColumn(right, columnNumber));
            }
        }
        return result;
    }


    public double[] getArraysIntersection(double[] first, double[] second, double epsilon) {
        double[] intersection = new double[first.length];
        int amountIntersection = 0;
        if (first != null && second != null) {
            for (int firstNumber = 0; firstNumber < first.length; firstNumber++) {
                for (int secondNumber = 0; secondNumber < second.length; secondNumber++) {
                    if (abs(first[firstNumber] - second[secondNumber]) < epsilon) {
                        intersection[amountIntersection] = first[firstNumber];
                        amountIntersection ++;
                    }
                }
            }
        }
        double[] result = new double[amountIntersection];
        System.arraycopy(intersection, 0, result, 0, amountIntersection);
        return result;
    }


    private boolean checkMatrix(int[][] matrix) {

        boolean isValid = true;
        int columnCount = 0;

        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            isValid = false;
        } else {
            columnCount = matrix[0].length;
        }

        for (int i = 1; isValid && i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length != columnCount) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private int getRowCount(int[][] matrix) {
        return matrix.length;
    }

    private int getColumnCount(int[][] matrix) {
        return matrix[0].length;
    }

    private int multiplyVector(int[] left, int[] right) {
        int result = 0;
        for (int i = 0; i < left.length; i++) {
            result += left[i] * right[i];
        }
        return result;
    }

    private int[] getRow(int[][] matrix,  int rowNumber) {
        return matrix[rowNumber];
    }

    private int[] getColumn(int[][] matrix, int columnNumber) {
        int[] result = new int[getRowCount(matrix)];
        for (int rowNumber = 0; rowNumber < getRowCount(matrix); rowNumber++) {
            result[rowNumber] = matrix[rowNumber][columnNumber];
        }
        return result;
    }
}
