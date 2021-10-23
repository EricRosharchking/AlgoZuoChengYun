package lesson7;

public class NQueenProblem {

    public static int approach1(int n) {
        if (n < 0) {
            return 0;
        }
        int[] arr = new int[n];
        return process1(0, arr, n);
    }

    // 目前来到了第i行
    // arr 代表所有的行 有数值则代表已经放过皇后
    // n 代表一共有多少行
    // 返回值是摆放完所有的皇后 一共有多少种摆法
    // i行之前的所有皇后都满足不共行 不共列 不共斜线
    public static int process1(int i, int[] arr, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { // i为当前行数，用递归来确定i行能不能放，以及i以后的行共有多少种摆法，j代表列数
            if (isValid(arr, i, j)) { // 当i行j列上放一个皇后满足它之前的所有行上的皇后都满足条件 则在此位置上放一个皇后
                // 然后向下一行考虑，每个满足条件的摆法会得到一个1，此方法会遍历所有可能性
                // 最后把所有的结果加起来，是一个遍历的方法
                arr[i] = j;
                res += process1(i + 1, arr, n);
            }
        }
        return res;
    }

    // i行以前的行需要判断 之后的行还没有放
    public static boolean isValid(int[] arr, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (arr[k] == j || Math.abs(i - k) == Math.abs(j - arr[k])) {
                return false;
            }
        }
        return true;
    }


    //limit是2进制数 位上为1 则代表这个位置上能放皇后 0 则代表这个位置上不能放皇后
    public static int approach2(int n) {
        if (n < 1 || n > 32) {
            return -1;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    //2进制数 
    public static int process2(int limit, int colLimit, int leftDiaLimit, int rightDiaLimit) {
        if (colLimit == limit) {
            return 1;
        }
        int res = 0;
        int rightMostOne = 0;
        int possible = limit & (~(colLimit | leftDiaLimit | rightDiaLimit)); // 所有可能放皇后的位置为1，不能放的位置为0
        while (possible != 0) {
            rightMostOne = possible & (~possible + 1);
            possible = possible - rightMostOne;
            res += process2(limit, 
                colLimit | rightMostOne, 
                (leftDiaLimit | rightMostOne) << 1, 
                (rightDiaLimit | rightMostOne) >>> 1);
        }
        return res;
    }
}
