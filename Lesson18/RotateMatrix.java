package Lesson18;

public class RotateMatrix {
    /*
     * rotate with constant variable(space) O(1) space complexity
     */

    public static void rotateEdge(int[][] matrix) {
        int a = 0, b = 0;
        int c = matrix.length - 1, d = matrix[0].length - 1;
        while (a < c) {
            int temp = 0;
            for (int i = 0; i < d - b; i++) {
                temp = matrix[a][b + i];
                matrix[a][b + i] = matrix[c - i][b];
                matrix[c - i][b] = matrix[c][d - i];
                matrix[c][d - i] = matrix[a + i][d];
                matrix[a + i][d] = temp;
            }
            a++;
            b++;
            c--;
            d--;
        }
    }
}
