package arrays;

/**
 * @author Albina Gimaletdinova on 11/10/2021
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        for (int i = cur; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}