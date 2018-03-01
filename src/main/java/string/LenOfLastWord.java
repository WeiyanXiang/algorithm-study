/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 1 Mar 2018
 */
public class LenOfLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space
     * characters ' ', return the length of last word in the string.
     * 
     * If the last word does not exist, return 0.
     * 
     * Note: A word is defined as a character sequence consists of non-space
     * characters only.
     * 
     * Example:
     * 
     * Input: "Hello World" Output: 5
     * 
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (count != 0)
                    return count;
                i--;
                continue;
            } else {
                count++;
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("5 == " + lengthOfLastWord("Hello World"));
        System.out.println("5 == " + lengthOfLastWord("Hello World  "));
        System.out.println("0 == " + lengthOfLastWord(" "));
    }
}
