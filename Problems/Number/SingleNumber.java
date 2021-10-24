package number;

/**
 * @author Albina Gimaletdinova on 24/10/2021
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}