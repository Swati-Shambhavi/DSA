import java.util.ArrayList;

public class SpirallyTraverseMatrix {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        System.out.println(spirallyTraverse(matrix, matrix.length, matrix[0].length));

    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;

        // 1 2 3 4
        // 5 6 7 8
        // 9 10 11 12
        // 13 14 15 16
        int rowbegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowbegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                ans.add(matrix[rowbegin][i]);
            }
            rowbegin++;

            for (int i = rowbegin; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowbegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowbegin; i--) {
                    ans.add(matrix[i][colBegin]);
                }
            }
            colBegin++;

        }
        return ans;
    }
}