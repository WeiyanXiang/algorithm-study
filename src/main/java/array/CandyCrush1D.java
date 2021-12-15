package array;

/**
 * @author Weiyan Xiang on 2020/6/22
 */
public class CandyCrush1D {

    /**
     * https://leetcode.com/discuss/interview-question/380650/Bloomberg-or-Phone-Screen-or-Candy-Crush-1D
     *
     * Write a function to crush candy in one dimensional board. In candy crushing games, groups of like items are
     * removed from the board. In this problem, any sequence of 3 or more like items should be removed and any items
     * adjacent to that sequence should now be considered adjacent to each other. This process should be repeated as
     * many time as possible. You should greedily remove characters from left to right.
     *
     * Example 1:
     *
     * Input: "aaabbbc"
     * Output: "c"
     * Explanation:
     * 1. Remove 3 'a': "aaabbbc" => "bbbc"
     * 2. Remove 3 'b': "bbbc" => "c"
     * Example 2:
     *
     * Input: "aabbbacd"
     * Output: "cd"
     * Explanation:
     * 1. Remove 3 'b': "aabbbacd" => "aaacd"
     * 2. Remove 3 'a': "aaacd" => "cd"
     * Example 3:
     *
     * Input: "aabbccddeeedcba"
     * Output: ""
     * Explanation:
     * 1. Remove 3 'e': "aabbccddeeedcba" => "aabbccdddcba"
     * 2. Remove 3 'd': "aabbccdddcba" => "aabbcccba"
     * 3. Remove 3 'c': "aabbcccba" => "aabbba"
     * 4. Remove 3 'b': "aabbba" => "aaa"
     * 5. Remove 3 'a': "aaa" => ""
     * Example 4:
     *
     * Input: "aaabbbacd"
     * Output: "acd"
     * Explanation:
     * 1. Remove 3 'a': "aaabbbacd" => "bbbacd"
     * 2. Remove 3 'b': "bbbacd" => "acd"
     * I solved it with recursion and also discussed the stack based approach.
     *
     * Follow-up:
     * What if you need to find the shortest string after removal?
     *
     * Example:
     *
     * Input: "aaabbbacd"
     * Output: "cd"
     * Explanation:
     * 1. Remove 3 'b': "aaabbbacd" => "aaaacd"
     * 2. Remove 4 'a': "aaaacd" => "cd"
     *
     */

    public String candyCrush(String s){
        return null;
    }

    public static void main(String[] args) {
        CandyCrush1D candyCrush = new CandyCrush1D();
        String actual = candyCrush.candyCrush("aabbbacd");
        System.out.println(actual+" == " + "cd");
    }


}
