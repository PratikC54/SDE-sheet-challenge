package Day_5;

public class SearchInMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int l = 0;
        int h = r * c - 1;

        while (l <= h) {
            int m = (l + h) / 2;

            int row = m / c;
            int col = m % c;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) h = m - 1;
            else l = m + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
    }
}
