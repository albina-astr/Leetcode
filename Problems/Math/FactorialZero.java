package math;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * @author Albina Gimaletdinova on 11/01/2022
 */
public class FactorialZero {
    /**
     * O(log n) - time
     * O(1) - space
     */
    public int trailingZeroes(int n) {
        int power = 5;
        int zeroes = 0;
        while (n / power > 0) {
            zeroes += n / power;
            power *= 5;
        }
        return zeroes;
    }
}
