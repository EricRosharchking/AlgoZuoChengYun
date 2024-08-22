package Lesson18;

public class FindNumberInMatrix {

    public static void main(String[] args) {

    }

    private int[] solution(int[][] matrix, int n) {
        int i = 0;
        int j = matrix[0].length-1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] < n) {
                i++;
            } else if (matrix[i][j] > n) {
                j--;
            } else {
                return new int[]{i,j};
            }
        }
        return null;
    }
}
