package Day_1;

/**
 * Question link -: <a href="https://leetcode.com/problems/pascals-triangle/description/">...</a>
 * Pascal Triangle - Each element is the sum of upper digonal elements starting with 1 as root.
 * Number_of_rows = 5
 *             1
 *            1 1
 *           1 2 1
 *          1 3 3 1
 *         1 4 6 4 1
 */
/*
Intuition:
Every row of Pascal's Triangle consists of binomial coefficients.

Instead of generating a row using the previous row, we directly compute
each element from the previous element using the relation:

C(n, r) = C(n, r-1) * (n-r+1) / r

Starting with 1, we repeatedly generate the next coefficient in O(1)
time and build the entire row. Repeating this for all rows produces the
complete Pascal's Triangle.

This avoids factorial calculations and generates each row efficiently.
*/


import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=1;i<=numRows;i++) {
            ans.add(generateRows(i));
        }
        return ans;
    }

    static List<Integer> generateRows(int row) {
        List<Integer> ansRow = new ArrayList<>();
        int ans = 1;
        ansRow.add(1);
        for (int i=1;i<row;i++) {
            ans*=(row-i);
            ans/=i;
            ansRow.add(ans);
        }
        return ansRow;
    }

    public static void main(String[] args) {

        System.out.println(generate(5));

    }
}
