package Day_1;

/**
 * Question link -: <a href="https://leetcode.com/problems/set-matrix-zeroes/description">...</a>
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 * 1 1 1           1 0 1
 * 1 0 1    ->     0 0 0
 * 1 1 1           1 0 1
 */

/*
Intuition:
Instead of using extra arrays to track which rows and columns should be
set to zero, use the first row and first column of the matrix itself as
markers.

1. Traverse the matrix and whenever a 0 is found:
   - Mark its row by setting matrix[i][0] = 0.
   - Mark its column by setting matrix[0][j] = 0.
2. Since matrix[0][0] cannot represent both the first row and first
   column simultaneously, use a separate variable (col0) to track whether
   the first column needs to be zeroed.
3. Traverse the matrix again (excluding the first row and column) and
   set matrix[i][j] = 0 if its row or column is marked.
4. Finally, handle the first row and first column separately based on
   their markers.

This achieves O(m*n) time complexity with O(1) extra space.
*/


public class SetMatrixZeros {

    static void setZeros(int[][] matrix) {
        int row = matrix.length,
            column = matrix[0].length,
            col0 = 1;
        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j!=0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i=1;i<row;i++) {
            for (int j=1;j<column;j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0)
            for (int j=0;j<column;j++)
                matrix[0][j] = 0;

        if (col0== 0)
            for (int i=0;i<row;i++)
                matrix[i][0] = 0;

        printMatrix(matrix);
    }

    static void printMatrix(int[][] matrix) {
        for (int i=0;i< matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeros(matrix);


    }
}
