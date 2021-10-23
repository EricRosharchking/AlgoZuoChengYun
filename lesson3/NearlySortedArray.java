package lesson3;

import java.util.PriorityQueue;

public class NearlySortedArray {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(5);
        heap.add(8);
        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(9);
        heap.add(3);

        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

    public static void sortNearlySortedArrayK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k+1);
        int index = 0;
        for (; index <= k; index++) {
            heap.add(arr[index]);
        }

        int i = 0;
        for (; index < arr.length; i++, index ++) {
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }

        while(!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
