package lesson13;

import java.util.Arrays;

import util.LessonUtil;

public class MinCoins {

    public static int min1(int[] arr, int aim) {
        return recursion1(arr, 0, aim);
    }

    public static int recursion1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int p1 = recursion1(arr, index + 1, rest);
        int p2 = recursion1(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2 == -1) {
            return -1;
        } else if (p1 == -1) {
            return p2 + 1;
        } else if (p2 == -1) {
            return p1;
        }
        return Math.min(p1, p2 + 1);
    }

    public static int min2(int[] arr, int aim) {
        int[][] cache = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < aim + 1; i++) {
                cache[i][j] = -2;
            }
        }
        return recursion2(arr, 0, aim, cache);
    }

    public static int recursion2(int[] arr, int index, int rest, int[][] cache) {
        if (rest == 0) {
            cache[index][rest] = 0;
        } else if (index == arr.length) {
            cache[index][rest] = -1;
        } else {
            int p1 = recursion2(arr, index + 1, rest, cache);
            int p2 = recursion2(arr, index + 1, rest - arr[index], cache);
            if (p1 == -1 && p2 == -1) {
                cache[index][rest] = -1;
            } else if (p1 == -1) {
                cache[index][rest] = p2 + 1;
            } else if (p2 == -1) {
                cache[index][rest] = p1;
            } else {
                cache[index][rest] = Math.min(p1, p2 + 1);
            }
        }
        return cache[index][rest];
    }

    public static int min3(int[] arr, int aim) {
        int[][] cache = new int[arr.length + 1][aim + 1];
        for (int index = 0; index < arr.length + 1; index++) {
            cache[index][0] = 0;
        }
        for (int rest = 1; rest < aim + 1; rest++) {
            cache[arr.length][rest] = -1;
        }
        for (int index = arr.length; index >= 0; index--) {
            for (int rest = 0; rest < aim + 1; rest++) {
                int p1 = cache[index + 1][rest];
                int p2 = rest - arr[index] >= 0 ? cache[index + 1][rest - arr[index]] : -1;
                if (p1 == -1 && p2 == -1) {
                    cache[index][rest] = -1;
                } else if (p1 == -1) {
                    cache[index][rest] = p2 + 1;
                } else if (p2 == -1) {
                    cache[index][rest] = p1;
                } else {
                    cache[index][rest] = Math.min(p1, p2 + 1);
                }
            }
        }

        return cache[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = LessonUtil.generatePositiveIntArray(10, 10);
        System.out.println(Arrays.toString(arr));
        System.out.println(min1(arr, 10));
    }
}
