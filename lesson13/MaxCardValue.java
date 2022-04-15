package lesson13;

import java.util.Arrays;

import util.ArrayUtil;

public class MaxCardValue {

    public static int maxValue1(int[] arr) {
        return Math.max(takeFirst1(arr, 0, arr.length - 1), takeLast1(arr, 0, arr.length - 1));
    }

    public static int takeFirst1(int[] arr, int leftBound, int rightBound) {
        if (leftBound == rightBound) {
            return arr[leftBound];
        }

        return Math.max(arr[leftBound] + takeLast1(arr, leftBound + 1, rightBound),
                arr[rightBound] + takeLast1(arr, leftBound, rightBound - 1));
    }

    public static int takeLast1(int[] arr, int leftBound, int rightBound) {
        if (leftBound == rightBound) {
            return 0;
        }

        return Math.min(takeFirst1(arr, leftBound + 1, rightBound), takeFirst1(arr, leftBound, rightBound - 1));
    }

    public static int maxValue2(int[] arr) {
        int[][] firstCache = new int[arr.length][arr.length];
        int[][] lastCache = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                firstCache[i][j] = -1;
                lastCache[i][j] = -1;
            }
        }
        return Math.max(takeFirst2(arr, 0, arr.length-1, firstCache, lastCache),
                takeLast2(arr, 0, arr.length-1, firstCache, lastCache));
    }

    public static int takeFirst2(int[] arr, int i, int j, int[][] firstCache, int[][] lastCache) {
        if (firstCache[i][j] == -1) {
            if (i == j) {
                firstCache[i][j] = arr[i];
            } else if (i < j) {
                firstCache[i][j] = Math.max(arr[i] + takeLast2(arr, i + 1, j, firstCache, lastCache),
                        arr[j] + takeLast2(arr, i, j - 1, firstCache, lastCache));
            } else {

            }
        }
        return firstCache[i][j];
    }

    public static int takeLast2(int[] arr, int i, int j, int[][] firstCache, int[][] lastCache) {
        if (lastCache[i][j] == -1) {
            if (i == j) {
                lastCache[i][j] = 0;
            } else if (i < j) {
                lastCache[i][j] = Math.min(takeFirst2(arr, i + 1, j, firstCache, lastCache),
                        takeFirst2(arr, i, j - 1, firstCache, lastCache));
            } else {

            }
        }
        return lastCache[i][j];
    }

    public static int maxValue3(int[] arr) {
        int[][] firstCache = new int[arr.length][arr.length];
        int[][] lastCache = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            firstCache[i][i] = arr[i];
            lastCache[i][i] = 0;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                firstCache[i][j] = Math.max(arr[i] + lastCache[i + 1][j],
                        arr[j] + lastCache[i][j - 1]);
                lastCache[i][j] = Math.min(firstCache[i + 1][j], firstCache[i][j - 1]);
            }
        }

        return Math.max(firstCache[0][arr.length - 1], lastCache[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int length = 10;
        int maxInt = 50;
        int executions = 1000;
        for (int i = 0; i < executions; i++) {
            int[] arr = ArrayUtil.generatePositiveIntArray(length, maxInt);
            // System.out.println(maxValue1(arr));
            // System.out.println(maxValue2(arr));
            // System.out.println(maxValue3(arr));
            if (maxValue1(arr) != maxValue2(arr) || maxValue2(arr) != maxValue3(arr)
                    || maxValue1(arr) != maxValue3(arr)) {
                System.out.println("Wrong Result");
                break;
            }
        }
    }
}
