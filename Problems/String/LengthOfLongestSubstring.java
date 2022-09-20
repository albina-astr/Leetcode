package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Albina Gimaletdinova on 10/08/2022
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> dict = new HashSet<>();
        int windowStart = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char cur = s.charAt(windowEnd);
            if (dict.contains(cur)) {
                while (dict.contains(cur)) {
                    char leftmost = s.charAt(windowStart);
                    dict.remove(leftmost);
                    windowStart++;
                }
            }
            dict.add(cur); // no else
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
