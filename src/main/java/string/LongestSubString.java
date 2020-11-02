/**
 *
 */
package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author weiyan.xiang
 * @date 14 Jan 2018
 */
public class LongestSubString {


    /**
     * my version, not efficient, O(n^2)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> sub = new HashSet<>();
        int i = 0, max = 0;
        char[] chars = s.toCharArray();
        while (i < chars.length) {
            int subMax = 0;
            int j = i;
            while (j < chars.length) {
                if (!sub.contains(chars[j])) {
                    sub.add(chars[j]);
                    subMax++;
                    max = Math.max(max, subMax);
                } else {
                    max = Math.max(max, subMax);
                    sub.clear();
                    i++;
                    break;
                }
                j++;
            }
        }
        return max;
    }

    /*
     * sub-optimal Time complexity : O(2n) = O(n)O(2n)=O(n). In the worst case
     * each character will be visited twice by ii and jj.
     *
     * Space complexity : O(min(m, n))O(min(m,n)). Same as the previous
     * approach. We need O(k)O(k) space for the sliding window, where kk is the
     * size of the Set. The size of the Set is upper bounded by the size of the
     * string nn and the size of the charset/alphabet mm.
     */
    private static int countSubStringLength(String s) {
        int count = 0, index = 0, slow = 0;
        Set<Character> cache = new HashSet<>();
        while (index < s.length()) {
            if (!cache.contains(s.charAt(index))) {
                cache.add(s.charAt(index++));
                count = Math.max(count, cache.size());
            } else {
                cache.remove(s.charAt(slow++));
            }
        }
        return count;
    }

    /*
     * use hashmap to validate whether it contains the key. essentially, instead
     * of using a slow pointer to iteratively remove the range until index, we
     * can skip by assigning the index to be Math.max(map.get(s.charAt(index)),
     * slow)
     */
    private static int countSubStringLengthOptimal(String s) {
        Map<Character, Integer> cacheMap = new HashMap<>();
        int slow = 0, answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            if (cacheMap.containsKey(element)) {
                slow = Math.max(slow, cacheMap.get(element) + 1);
            }
            answer = Math.max(answer, i - slow + 1);
            cacheMap.put(element, i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countSubStringLength("pwwkew") + " == 3");
        System.out.println(countSubStringLengthOptimal("pwwkew") + " == 3");
        System.out.println(countSubStringLength("bbbbbb") + " == 1");
        System.out.println(countSubStringLengthOptimal("bbbbbb") + " == 1");
        System.out.println(countSubStringLength("abcabcbb") + " == 3");
        System.out.println(countSubStringLengthOptimal("abcabcbb") + " == 3");
    }
}
