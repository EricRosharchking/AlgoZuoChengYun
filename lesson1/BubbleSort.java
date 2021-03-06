package lesson1;

public class BubbleSort {
    public static void main(String[] args) {

    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int e = arr.length - 1; e > 0; e--) { //e: end of the unsorted arr
            for (int i = 0; i < e; i ++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        //arr[i] = arr[j] + arr[i];
		//arr[j] = arr[i] - arr[j];
		//arr[i] = arr[i] - arr[j];
        
		arr[j] = arr[j] ^ arr[i];
		arr[i] = arr[j] ^ arr[i];
		arr[j] = arr[j] ^ arr[i];
    }
}
