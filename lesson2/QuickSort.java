package lesson2;

import java.util.Arrays;

public class QuickSort {
    
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if (R - L > 1) {
            int i = partition(arr, L, R);
            sort(arr, L, i-1);
            sort(arr, i+1, R);
        } else if (L < R && arr[L] > arr[R]) {
            swap(arr, L, R);
        }
    }

    public static int partition(int[] arr, int L, int R) {
        int pivot = arr[L];
        int i = L;
        for (int j = L + 1; j <= R; j++) {
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
        // swap(arr, L, i);
        System.out.println("i: " + i + "," + Arrays.toString(arr));
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
