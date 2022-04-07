package lesson11;

import java.util.Stack;

public class IndexAProblem {

    /*
     * indexA: the product of cumulative sum of an array of positive integers and
     * the smallest element of this array
     * So every sub array of a given array shall also have its own indexA
     * 
     * Question: given an array of positive integers, what's the largest indexA of
     * all its sub arrays?
     * Requirement: T=O(N)
     */

    /*
     * Guide: for every element of int[] arr, treat it as the smallest element of an
     * sub array,
     * meaning find the two elements closest to it and smaller than it - it will be
     * the boundaries of the sub array that has the element as the smallest,
     * then times it with the cumulative sum of this sub array
     * The answer to the question is one of this product
     */

    public static int maxIndexAOfAllSubArrays(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] cumulativeSum = new int[arr.length];
        cumulativeSum[0] = arr[0];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int position = stack.pop();
                left[position] = stack.isEmpty() ? -1 : stack.peek();
                right[position] = i;
            }
            stack.push(i);
            if (i > 0) {
                cumulativeSum[i] += arr[i - 1];
            }
        }
        while (!stack.isEmpty()) {
            int position = stack.pop();
            left[position] = stack.isEmpty() ? -1 : stack.peek();
            right[position] = -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int leftBound = left[i] > -1 ? left[i] : 0;
            int rightBound = right[i] > -1 ? right[i] : arr.length - 1;
            max = Math.max(max, (cumulativeSum[rightBound] - cumulativeSum[leftBound]) * arr[i]);
        }
        return max;
    }
}
