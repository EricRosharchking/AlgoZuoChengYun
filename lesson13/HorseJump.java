package lesson13;

public class HorseJump {

    public static int jump(int a, int b, int k) {
        return process(a, b, k);
    }

    public static int process(int x, int y, int steps) {
        if (x < 0 || y < 0 || x > 8 || y > 9) {
            return 0;
        }
        if (x == 0 && y == 0 && steps == 0) {
            return 1;
        }

        return process(x - 2, y - 1, steps - 1) + process(x - 2, y + 1, steps - 1) + process(x - 1, y + 2, steps - 1)
                + process(x + 1, y + 2, steps - 1) + process(x + 2, y + 1, steps - 1) + process(x + 2, y - 1, steps - 1)
                + process(x + 1, y - 2, steps - 1) + process(x - 1, y - 2, steps - 1);
    }

    public static int jumpWithCache(int a, int b, int k) {
        if (a < 0 || b < 0 || a > 8 || b > 9 || k < 0) {
            return 0;
        }
        int[][][] cache = new int[9][10][k + 1];
        cache[0][0][0] = 1;
        for (int h = 1; h < k + 1; h++) {
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 10; y++) {
                    cache[x][y][h] = 0 + getValueFromCube(cache, x - 2, y - 1, h - 1)
                            + getValueFromCube(cache, x - 2, y + 1, h - 1)
                            + getValueFromCube(cache, x - 1, y + 2, h - 1)
                            + getValueFromCube(cache, x + 1, y + 2, h - 1)
                            + getValueFromCube(cache, x + 2, y + 1, h - 1)
                            + getValueFromCube(cache, x + 2, y - 1, h - 1)
                            + getValueFromCube(cache, x + 1, y - 2, h - 1)
                            + getValueFromCube(cache, x - 1, y - 2, h - 1);
                }
            }
        }
        return cache[a][b][k];
    }

    public static int getValueFromCube(int[][][] cache, int x, int y, int h) {
        if (x < 0 || y < 0 || x > 8 || y > 9) {
            return 0;
        }
        return cache[x][y][h];
    }
}
