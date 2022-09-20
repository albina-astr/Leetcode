package string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * @author Albina Gimaletdinova on 03/08/2022
 */
public class LongestSubstringKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = Integer.MIN_VALUE;

        int windowStart = 0;
        Map<Character, Integer> dict = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);
            dict.put(ch, dict.getOrDefault(ch, 0) + 1);

            while (dict.size() > k) {
                char toDelete = s.charAt(windowStart);
                int count = dict.get(toDelete);
                if (count - 1 == 0) {
                    dict.remove(toDelete);
                } else {
                    dict.put(toDelete, count - 1);
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
