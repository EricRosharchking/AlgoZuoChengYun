package Lesson18;

public class SpiralMatrix {
    public static void print(int[][] matrix) {
        // int[][] matrix= {{0,1,2},{3,4,5},{6,7,8}};\
        int a = 0, b = 0;
        int c = matrix.length-1, d = matrix[0].length-1;
        while (a <= c && b <= d) {
            if (a == c) { // it's a column
                for (int i = b; i <= d; i++) {
                    System.out.println(matrix[a][i] + " ");
                }
            } else if (b == d) {// it's a row
                for (int i = a; i <= c; i++) {
                    System.out.println(matrix[i][b] + " ");
                }
            } else {
                int i = b;
                int j = a;
                while (i != d) {
                    // print top row
                    System.out.println(matrix[a][i] + " ");
                    i++;
                }
                while (j != c) {
                    // print right column
                    System.out.println(matrix[j][d] + " ");
                    j++;
                }
                while (i != b) {
                    // print bottom row
                    System.out.println(matrix[c][i] + " ");
                    i--;
                }
                while (j != a) {
                    // print left column
                    System.out.println(matrix[j][b] + " ");
                    j--;
                }
            }
            a++;b++;c--;d--;
        }
    }
}
