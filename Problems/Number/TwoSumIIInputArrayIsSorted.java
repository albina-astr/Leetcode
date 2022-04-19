package number;

/**
 * @author Albina Gimaletdinova on 19/04/2022
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            long sum = arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }
}
