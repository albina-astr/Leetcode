package math;

/**
 * https://leetcode.com/problems/count-primes/
 *
 * @author Albina Gimaletdinova on 17/01/2022
 */
public class CountPrimes {
    /**
     * O(sqrt(n) log log n) - time complexity
     * O(n) - space
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] compounds = new boolean[n];

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            for (int j = i * i; j < n; j += i) {
                compounds[j] = true;
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!compounds[i]) res++;
        }
        return res;
    }
}
