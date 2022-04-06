package lesson11;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaxArray {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        System.out.println(Arrays.toString(getMaxWindow(arr, w)));
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < 1) {
            return null;
        }
        LinkedList<Integer> dequeue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int i = 0;
        while (i < w) {
            pushToLast(dequeue, arr, i++);
        }
        res[0] = arr[dequeue.peekFirst()];
        while (i < arr.length) {
            pushToLast(dequeue, arr, i++);
            if (i - w == dequeue.peekFirst()) {
                res[i - w] = arr[dequeue.pollFirst()];
            } else {
                res[i - w] = arr[dequeue.peekFirst()];
            }
        }
        return res;
    }

    private static void pushToLast(LinkedList<Integer> dequeue, int[] arr, int index) {
        while (!dequeue.isEmpty() && arr[dequeue.peekLast()] <= arr[index]) {
            dequeue.pollLast();
        }
        dequeue.addLast(index);
        System.out.println(dequeue.toString() + ", added: " + index);
    }
}
