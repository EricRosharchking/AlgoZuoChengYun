package lesson10;

public class Islands {

    public static int coutIslands(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return 0;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    res++;
                    infect(matrix, i, j, rows, columns);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] matrix, int i, int j, int rows, int columns) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || matrix[i][j] != 1)
            return;

        matrix[i][j] = 2;
        infect(matrix, i + 1, j, rows, columns);
        infect(matrix, i - 1, j, rows, columns);
        infect(matrix, i, j + 1, rows, columns);
        infect(matrix, i, j - 1, rows, columns);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 1, 0, 1, 0 },
                { 1, 1, 1, 0, 1, 0 },
                { 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        System.out.println(coutIslands(matrix));
    }
}
