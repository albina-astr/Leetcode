package number;

/**
 * @author Albina Gimaletdinova on 05/11/2021
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxSeqLen = 0;
        int curSeqLen = 0;
        for (int i : arr) {
            if (i == 1) {
                curSeqLen++;
            } else {
                maxSeqLen = Math.max(maxSeqLen, curSeqLen);
                curSeqLen = 0;
            }
        }
        return Math.max(maxSeqLen, curSeqLen);
    }
}