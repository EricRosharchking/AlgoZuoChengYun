package Lesson18;

public class FindLargestSquareInMatrix {
    
    /*一个由0和1组成的矩阵，每一行中1总是在0的右边
     * 求矩阵中由1组成的正方形的最大边长
     */

     public static void main(String[] args) {
        
     }

     public int solution(int[][] matrix) {
        int ans = 0;
        int i = 0;
        int j = matrix[0].length-1;
        int offset = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == 0) {
                i++;
            } else {
                offset = i;
                
            }
        }
        return ans;
     }
}
