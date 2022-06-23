package math;

/**
 * https://leetcode.com/problems/sqrtx/
 *
 * @author Albina Gimaletdinova on 26/01/2022
 */
public class Sqrt {
    public int sqrt(int n) {
        int left = 0, right = n + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
