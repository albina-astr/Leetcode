package arrays;

/**
 * @author Albina Gimaletdinova on 24/10/2021
 */
public class FindMaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }

        boolean includedOneZero = false;
        int curLen = 0;
        int maxLen = 0;
        int zeroIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                curLen++;
            } else {
                if (!includedOneZero) {
                    curLen++;
                    includedOneZero = true;
                    zeroIndex = i;
                } else {
                    maxLen = Math.max(maxLen, curLen);
                    curLen = 0;
                    includedOneZero = false;
                    i = zeroIndex;
                }
            }
        }
        return Math.max(maxLen, curLen);
    }
}
