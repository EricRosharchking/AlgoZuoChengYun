package lesson11;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStackQuestion {

    /*
     * Question: given an array of int arr, and an index i,
     * get the closest numbers to i on both side of i which are bigger than arr[i]
     * Requirement: T=O(N) for the entire array
     */
    private static int[] left;
    private static int[] right;

    public static void getResultArray(int[] arr) {
        left = new int[arr.length];
        right = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int position = stack.pop();
                left[position] = stack.isEmpty() ? -1 : stack.peek();
                right[position] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int position = stack.pop();
            left[position] = stack.isEmpty() ? -1 : stack.peek();
            right[position] = -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 7, 2, 5, 1, 6 };
        System.out.println(Arrays.toString(arr));
        getResultArray(arr);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
    }
}
