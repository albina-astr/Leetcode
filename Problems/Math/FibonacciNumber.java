package math;

/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * @author Albina Gimaletdinova on 05/04/2022
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0, second = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }

        return res;
    }
}
