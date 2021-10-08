package arrays;

/**
 * @author Albina Gimaletdinova on 08/10/2021
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int i = m + n - 1;

        while (i1 != -1 || i2 != -1) {
            if (i1 != -1 && i2 != -1) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[i] = nums1[i1];
                    i1-=1;
                } else {
                    nums1[i] = nums2[i2];
                    i2-=1;
                }
            } else if (i1 != -1) {
                nums1[i] = nums1[i1];
                i1-=1;
            } else {
                nums1[i] = nums2[i2];
                i2-=1;
            }
            i-=1;
        }

    }
}