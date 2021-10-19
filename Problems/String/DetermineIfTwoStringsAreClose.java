package string;

/**
 * @author Albina Gimaletdinova on 19/10/2021
 */
public class Solution {
    public boolean closeStrings(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        int bitmap1 = 0;
        int bitmap2 = 0;

        for (char ch : w1.toCharArray()) {
            bitmap1 = bitmap1 | (1 << ch - 'a');
            map1[ch - 'a']++;
        }

        for (char ch : w2.toCharArray()) {
            bitmap2 = bitmap2 | (1 << ch - 'a');
            map2[ch - 'a']++;
        }

        if (bitmap1 != bitmap2) {
            return false;
        }

        Arrays.sort(map1);
        Arrays.sort(map2);
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}

package string;
