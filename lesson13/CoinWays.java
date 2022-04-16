package lesson13;

public class CoinWays {

    public static int ways1(int[] arr, int aim) {
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int aim) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }

        int ways = 0;
        for (int count = 0; count * arr[index] <= aim; count++) {
            ways += process1(arr, index+1, aim-count*arr[index]);
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;

        for (int index = 0; index <= N; index++) {
            for (int rest = 0; rest <= aim;rest++) {
                int ways = 0;
                for (int count = 0; count * arr[index] <= rest; count++) {
                    ways += dp[index+1][rest-count*arr[index]];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public static int ways3(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;

        for (int index = 0; index <= N; index++) {
            for (int rest = 0; rest <= aim;rest++) {
                dp[index][rest] = dp[index+1][rest];
                if (rest - dp[index+1][rest] >= 0) {
                    dp[index][rest] += dp[index][rest - dp[index+1][rest]];
                }
            }
        }
        return dp[0][aim];
    }
}
