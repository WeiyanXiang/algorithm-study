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
    public int firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (map.containsKey(cs[i])) map.put(cs[i], -1);
            else map.put(cs[i], i);
        }

        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) != -1) return map.get(cs[i]);
        }
        return -1;
    }
}
