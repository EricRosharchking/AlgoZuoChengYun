package lesson7;

import java.util.PriorityQueue;

public class SplitGold {
    // Huffman coding

    public static int leastMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        while (heap.size() > 1) {
            int cur = heap.poll() + heap.poll();
            res += cur;
            heap.add(cur);
        }
        return res;
    }
}
