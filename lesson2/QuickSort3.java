package lesson2;

public class QuickSort3 {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, (int) (L + Math.random() * (R - L + 1)), R);
            int[] partition = partition(arr, L, R);
            sort(arr, L, partition[0] - 1); // 对<区排序
            sort(arr, partition[1] + 1, R); // 对>区排序
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int a = L - 1; // <区 的右边界
        int b = R; // >区 的左边界
        while (L < b) { // L表示当前数的位置 arr[R] 为pivot
            if (arr[L] < arr[R]) { // 当前数小于pivot
                swap(arr, ++a, L++); // <区向右推进一位
            } else if (arr[L] > arr[R]) { // 当前数大于pivot
                swap(arr, --b, L); // >区向左推进一位
            } else {
                L++; // 等于区扩大一位
            }
        }
        swap(arr, b, R);
        return new int[] { a + 1, b };
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        }
    }
}
