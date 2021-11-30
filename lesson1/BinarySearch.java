package lesson1;

public class BinarySearch {
    

    public static int search(int[] arr, int num, int start, int end) {

        if (arr == null || arr.length < 2 || start == end) {
            return start;
        }
        int mid = (start + end) / 2;

        if (num < arr[mid]) {
            return search(arr, num, start, mid);
        }
        if (num > arr[mid]) {
            return search(arr, num, mid, end);
        }

        return mid;

    }
}
