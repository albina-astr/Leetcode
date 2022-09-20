package string;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * @author Albina Gimaletdinova on 13/09/2022
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
