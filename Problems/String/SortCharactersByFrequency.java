package string;

/**
 * @author Albina Gimaletdinova on 13/10/2021
 */
public class Solution {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int[] frequencies = new int[256];
        for (char a : s.toCharArray()) {
            frequencies[a]++;
        }

        Map<Integer, Set<Character>> freqMap = new HashMap<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                Set<Character> freq = freqMap.getOrDefault(frequencies[i], new HashSet<>());
                freq.add((char)(i));
                freqMap.put(frequencies[i], freq);
            }
        }

        StringBuilder res = new StringBuilder(s.length());
        int counter = s.length();
        while (counter > 0) {
            Set<Character> chars = freqMap.get(counter);
            if (chars != null) {
                for (char e : chars) {
                    char[] arr = new char[counter];
                    Arrays.fill(arr, e);
                    String oneLetterStr = new String(arr);
                    res.append(oneLetterStr);
                }
            }
            counter--;
        }

        return res.toString();
    }
}