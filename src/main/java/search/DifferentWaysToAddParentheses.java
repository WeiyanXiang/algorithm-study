package search;/**
 * @author Weiyan Xiang on 2021/1/17
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    /**
     * 241. Different Ways to Add Parentheses
     * <p>
     * https://leetcode.com/problems/different-ways-to-add-parentheses/
     * <p>
     * upvoted ans, recursion with memorisation (remove memorised map is always AC)
     */
    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String p1 = input.substring(0, i);
                String p2 = input.substring(i + 1);
                List<Integer> l1 = map.containsKey(p1) ? map.get(p1) : diffWaysToCompute(p1);
                List<Integer> l2 = map.containsKey(p2) ? map.get(p2) : diffWaysToCompute(p2);
                for (int a : l1) {
                    for (int b : l2) {
                        int cr = 0;
                        switch (c) {
                            case '+':
                                cr = a + b;
                                break;
                            case '-':
                                cr = a - b;
                                break;
                            case '*':
                                cr = a * b;
                                break;
                        }
                        res.add(cr);
                    }
                }
            }

        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }
}
