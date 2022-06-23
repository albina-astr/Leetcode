package math;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * @author Albina Gimaletdinova on 24/02/2022
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        // some logic behind
        return true;
    }
}
