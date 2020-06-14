package string;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/5/29
 */
public class ValidAnagram {

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "anagram", t = "nagaram" Output: true Example 2:
     * <p>
     * Input: s = "rat", t = "car" Output: false Note: You may assume the string contains only lowercase alphabets.
     * <p>
     * Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
     * <p>
     * https://leetcode.com/problems/valid-anagram/
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        Stack<Character> ss = new Stack<>();
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        for (int j = 0; j < t.length(); j++) alph[t.charAt(j) - 'a']--;
        for (int e : alph) if (e != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println("false == " + validAnagram.isAnagram("rat", "car"));
        System.out.println("true == " + validAnagram.isAnagram("anagram", "nagaram"));
    }

}
