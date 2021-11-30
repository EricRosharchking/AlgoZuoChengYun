package lesson3;

public class HeapSort {

    public static void heapSort(int[] arr) {
        // 将所有元素插入大根堆中
        // for (int i = 0; i < arr.length; i++) {
        // heapInsert(arr, i);
        // }

        // 上面的过程可以用以下代码代替 (更简便 但同为 O(N*log(N)))
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) >> 1]) {
            swap(arr, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) + 1; // left child node index

        while (left < heapSize) { // left child is within the heap
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left; // 子节点中更大的元素的指针

            largest = arr[index] < arr[largest] ? largest : index; // index和子结点中更大元素的指针

            if (largest == index) { // index元素本身就是更大的那个，即index元素是这个子树的最大元素，即以index为头节点的堆是一个大根堆
                break;
            }

            swap(arr, index, largest);

            index = largest;
            left = (index << 1) + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
