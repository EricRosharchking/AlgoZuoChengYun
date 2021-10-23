package lesson1;

public class LocalMinimum {
    
    public static void main(String[] args) {

    }

    public static void findLocalMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            System.out.println(0);
            return;
        }
        if (arr[arr.length-2] > arr[arr.length-1]) {
            System.out.println(arr.length-1);
            return;
        }

        int a = 0;
        int b = arr.length - 1;
        int m = (a + b) / 2;
        while (!(arr[m-1] > arr[m] && arr[m+1] > arr[m]) /*&& !(m > a || m < b)*/) {
            if (arr[m-1] < arr[m]) {
                b = m;
                m = (a + b) / 2;
            } else if (arr[m] > arr[m+1]) {
                a = m;
                m = (a + b) / 2;
            }
        }
        System.out.println(m);

        // int mid = 0;
        // int left = 1;
        // int right = x.length - 2;
        // while (left < right) {
        //     mid = (left + right) / 2;
        //     if (x[mid - 1] < x[mid]) {
        //         right = mid - 1;
        //     } else if (x[mid + 1] < x[mid]) {
        //         left = mid + 1;
        //     } else {
        //         return mid;
        //     }
        // }
        // return left;
    }
}
