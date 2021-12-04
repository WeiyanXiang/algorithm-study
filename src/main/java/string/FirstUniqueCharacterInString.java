package string;/**
 * @author Weiyan Xiang on 2021/12/1
 */

import java.util.*;

public class FirstUniqueCharacterInString {
    /**
     * 387. First Unique Character in a String
     * <p>
     * https://leetcode.com/problems/first-unique-character-in-a-string/
     * <p>
     * map or array with size 26
     */
    public int firstUniqCharUsingArray(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    public int firstUniqCharUsingMap(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            // if duplicate, put -1
            if (map.containsKey(cs[i])) map.put(cs[i], -1);
            else map.put(cs[i], i);
        }

        for (int i = 0; i < cs.length; i++) {
            // if not -1, then must be the index of single element
            if (map.get(cs[i]) != -1) return map.get(cs[i]);
        }
        return -1;
    }
}
