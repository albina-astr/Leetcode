package arrays;

/**
 * @author Albina Gimaletdinova on 29/01/2022
 */
public class MaximumNumberOfPairsInAnArray {
    public int[] numberOfPairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{0, 0};
        }
        int[] freq = new int[101];
        for (int i : arr) {
            freq[i]++;
        }
        int pairsCount = 0;
        int remainingElements = 0;
        for (int i = 0; i < freq.length; i++) {
            pairsCount += freq[i] / 2;
            remainingElements += freq[i] % 2;
        }

        return new int[]{pairsCount, remainingElements};
    }
}
