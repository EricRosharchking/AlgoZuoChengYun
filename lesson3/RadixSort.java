package lesson3;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // adjustedSort(arr, 0, arr.length-1, maxBits(arr));
        sort(arr, maxBits(arr));
    }

    public static int maxBits(int[] arr) { // 找到数组中最大的数有多少十进制位,也是所有数字出桶入桶的次数
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = i > max ? i : max;
        }

        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void adjustedSort(int[] arr, int L, int R, int digit) { // 在数组中对L到R上的元素进行排序
        final int radix = 10; // 10进制
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            // 10个空间
            // count[0]d位上是0的元素有多少个
            // count[1]d位上是1的元素有多少个
            // count[2]d位上是2的元素有多少个
            // count[3]d位上是3的元素有多少个
            // ...

            for (i = L; i < R; i++) { // 计算原数组中d位上等于[0..9]的重复情况
                j = getBit(arr[i], d);
                count[j]++;
            }

            for (i = 1; i < radix; i++) { // 将count转化为原数组中d位上小于等于[0..9]]的情况
                count[i] = count[i - 1] + count[i];
            }

            for (i = R; i >= L; i--) { // 将数组中的元素 从右到左按照d位上的数字大小放入桶中，即保留d位相等的元素在原数组中的相对位置
                j = getBit(arr[i], d);
                bucket[count[j]--] = arr[i];
            }

            for (i = L, j = 0; i < R; i++, j++) { // 将桶中元素从左往右依次倒回数组中,完成对d位上的排序
                arr[i] = bucket[j];
            }
        }

    }

    public static int getBit(int i, int d) { // number i on digit d
        int res = 0;
        for (int a = 1; a <= d; a++) {
            res = i % 10;
            i /= 10;
        }
        return res;
    }

    public static void sort(int[] arr, int maxBits) {
        int[][] buckets = new int[10][10]; // buckets of 0..9 for number on each bit
        int radix = 10;
        for (int bit = 0; bit < maxBits; bit++) { // loop all elements of arr on each bit
            // System.out.println("bit: " + bit);
            for (int d = 0; d < radix; d++) { // put elements of arr into the buckets based on the digit d on bit
                // System.out.println("d: " + d);
                int bucketIndex = 0;
                for (int original = 0; original < arr.length; original++) {
                    // System.out.println("original: " + original);
                    if (arr[original] / (int) Math.pow(10, bit) % 10 == d)
                        buckets[d][bucketIndex++] = arr[original];

                }
                // System.out.println(Arrays.toString(buckets[d]));
            }
            // System.out.println("=============================================");
            // for (int[] bucket : buckets) System.out.println(Arrays.toString(bucket));
            int original = 0;
            for (int d = 0; d < radix; d++) { // loop all buckets and put the elements back to arr,
                                              // retain the bucket sequence and original adding sequence
                
                for (int num : buckets[d]) {
                    if (num != 0) {
                        // System.out.println(num);
                        arr[original++] = num;
                    }
                }
            }
            //System.out.println(Arrays.toString(arr));

            buckets = new int[10][10];
        }

    }
}
