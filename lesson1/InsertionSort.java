package lesson1;

public class InsertionSort {
    
    public static void main(String[] args) {

    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j+1] < arr[j]) {
                    swap(arr, j+1, j);
                } else {
                    continue;
                }
            }

            // for (int j = i - 1; j >= 0 && arr[j+1] < arr[j]; j--) {
            //     swap(arr, j, j+1);
            // }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^  arr[j];
        arr[j] = arr[i] ^  arr[j];
        arr[i] = arr[i] ^  arr[j];
    }
}
