package Lesson18;

public class PrintZigZag {
    public static void print(int[][] matrix) {
        int ar = 0, ac = 0;
        int br = 0, bc = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromTop = false;
        while (ar != endR + 1) {
            printLevel(matrix, ar, ac, br, bc, fromTop);
            ar = ac == endC ? ar + 1 : ar;
            ac = ac == endC ? ac : ac + 1;
            br = br == endR ? br : br + 1;
            bc = br == endR ? bc + 1 : bc;
            fromTop = !fromTop;
        }
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }
}
