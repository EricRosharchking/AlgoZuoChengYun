package lesson2;

public class QuickSort {
    

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        int i = partition(arr, L, R);
        sort(arr, L, i-1);
        sort(arr, i+1, R);
    }

    public static int partition(int[] arr, int L, int R) {
        int pivot = arr[L];
        int i = L;
        for (int j = L + 1; j < R; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, L, i);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
