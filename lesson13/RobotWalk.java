package lesson13;

public class RobotWalk {

    public static int walkWays(int N, int S, int E, int K) {
        return recursion(N, S, E, K);
    }

    /**
     * 
     * @param N     length of map, fixed parameter
     * @param curr  current position of the robot, 1 <= curr <= N
     * @param DEST  destination of the robot, fixed parameter
     * @param steps remaining steps to take
     * @return number of different ways of walking
     */
    public static int recursion(int N, int curr, int DEST, int steps) {
        if (steps == 0) {
            return curr == N ? 1 : 0;
        }
        if (curr == 1) {
            return recursion(N, 2, DEST, steps - 1);
        }
        if (curr == N) {
            return recursion(N, N - 1, DEST, steps - 1);
        }
        return recursion(N, curr - 1, DEST, steps - 1) + recursion(N, curr + 1, DEST, steps + 1);
    }

    public static int walkWaysMemorySearch(int N, int S, int E, int K) {
        int[][] cache = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                cache[i][j] = -1;
            }
        }
        return recursionWithCache(N, S, E, K, cache);
    }

    public static int recursionWithCache(int N, int curr, int DEST, int steps, int[][] cache) {
        if (cache[curr][steps] == -1) {
            if (curr == 1) {
                cache[curr][steps] = recursionWithCache(N, curr + 1, DEST, steps - 1, cache);
            } else if (curr == N) {
                cache[curr][steps] = recursionWithCache(N, curr - 1, DEST, steps - 1, cache);
            } else {
                cache[curr][steps] = recursionWithCache(N, curr + 1, DEST, steps - 1, cache)
                        + recursionWithCache(N, curr - 1, DEST, steps - 1, cache);
                ;
            }
        }
        return cache[curr][steps];
    }
}
