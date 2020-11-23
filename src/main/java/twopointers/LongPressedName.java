package twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2020/11/22
 */
public class LongPressedName {
    /**
     * 925. Long Pressed Name
     * <p>
     * https://leetcode.com/problems/long-pressed-name/
     * <p>
     * my own ac answer
     */
    public boolean isLongPressedName(String name, String typed) {
        int ni = 0, ti = 0;
        char prev = name.charAt(0);
        while (ni < name.length() && ti < typed.length()) {
            char t = typed.charAt(ti);
            char n = name.charAt(ni);
            if (t == n) {
                ni++;
                prev = n;
            } else if (prev != t) {
                return false;
            }
            ti++;
        }
        // for case like: "alex" "aaleexxr"
        while (ti < typed.length()) {
            if (typed.charAt(ti) == name.charAt(name.length() - 1)) ti++;
            else return false;
        }
        return ni == name.length();
    }
}
