package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weiyan Xiang on 2023/1/1
 */

public class WordPattern {
    /**
     * Given a pattern and a string s, find if s follows the same pattern.
     * <p>
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word
     * in s.
     */
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) return false;
        Map<Character, String> map = new HashMap<>();
        char[] ps = pattern.toCharArray();
        for (int i = 0; i < ps.length; i++) {
            if (map.containsKey(ps[i])) {
                if (!map.get(ps[i]).equals(ss[i])) return false;
            } else {
                if (map.containsValue(ss[i])) return false;
                map.put(ps[i], ss[i]);
            }
        }
        return true;
    }
}
