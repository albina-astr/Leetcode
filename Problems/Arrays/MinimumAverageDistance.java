package arrays;

/**
 * @author Albina Gimaletdinova on 19/10/2021
 */
public class Solution {
    public int minimumAverageDifference(int[] arr) {
        long totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        int minAvgDifIndex = -1;
        int minAvgDif = Integer.MAX_VALUE;
        long curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];

            long leftPart = curSum / (i + 1);
            long rightPart = 0;
            if (i != arr.length - 1) {
                rightPart = (totalSum - curSum) / (arr.length - i - 1);
            }
            int curAvgDif = (int) Math.abs(leftPart - rightPart);
            if (curAvgDif < minAvgDif) {
                minAvgDifIndex = i;
                minAvgDif = curAvgDif;
            }
        }

        return minAvgDifIndex;
    }

    //WORKS, BUT CAN BE OPTIMIZED
    // public int minimumAverageDifference(int[] arr) {
    //     if (arr == null || arr.length == 0) {
    //         return -1;
    //     }

    //     long[] cumSum = new long[arr.length + 1];
    //     for (int i = 1; i < cumSum.length; i++) {
    //         cumSum[i] = cumSum[i - 1] + arr[i - 1];
    //     }

    //     int minAvgIndex = -1;
    //     int minAvgDiff = Integer.MAX_VALUE;
    //     int last = cumSum.length - 1;
    //     for (int i = 1; i < cumSum.length; i++) {
    //         int right = last - i > 0 ? (int)((cumSum[last] - cumSum[i]) / (last - i)) : 0;
    //         int currAvgDiff = Math.abs((int)(cumSum[i] / i) - right);
    //         if (currAvgDiff < minAvgDiff) {
    //             minAvgIndex = i - 1;
    //             minAvgDiff = currAvgDiff;
    //         }
    //     }
    //     return minAvgIndex;
    // }
}