package string;

/**
 * @author Albina Gimaletdinova on 20/11/2022
 */
public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.add(ch)) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }
}