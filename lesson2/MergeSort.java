package lesson2;

public class MergeSort {
    
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int L, int R) { // array, Left and Right indices
        if (L == R) {
            return;
        }

        int mid = L + (R - L) >> 2;
        sort(arr, L, mid);
        sort(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = R;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
    }
}
