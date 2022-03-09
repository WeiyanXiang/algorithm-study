package string;/**
 * @author Weiyan Xiang on 2022/3/9
 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
     * 13. Roman to Integer
     * <p>
     * https://leetcode.com/problems/roman-to-integer/
     * <p>
     * my ac ans: use map to solve
     */
    public int romanToInt(String s) {
        int sum = 0;
        Map<String, Integer> map = getConvertMap();
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                sum += map.get(s.substring(i, i + 2));
                i = i + 2;
            } else {
                sum += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }

    private Map<String, Integer> getConvertMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("M", 1000);
        return map;
    }
}
