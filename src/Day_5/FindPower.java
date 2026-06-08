package Day_5;

/**
 * Question link -: <a href="https://leetcode.com/problems/powx-n/description/">...</a>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 */

public class FindPower {

    public static double myPow(double x, int n) {
        return Math.pow(x,n);
    }
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }
}
