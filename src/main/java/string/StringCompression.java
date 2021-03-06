package string;

/**
 * @author Weiyan Xiang on 2020/3/5
 * <p>
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {


    public static int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if (count != 1)
                for (char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }


    public static void main(String[] args) {
        char[] chars0 = {'a'};
        printChars(chars0);

        char[] chars5 = {'a', 'b', 'c'};
        printChars(chars5);

        char[] chars4 = {'a', 'a'};
        printChars(chars4);

        char[] chars1 = {'a', 'b', 'b', 'b', 'c'};
        printChars(chars1);

        char[] chars2 = {'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'};
        printChars(chars2);

        char[] chars3 = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b'};
        printChars(chars3);
    }

    private static void printChars(char[] chars) {
        int digits = compress(chars);
        System.out.print('[');
        for (int i = 0; i < digits; i++) {
            if (i < digits - 1) {
                System.out.print(chars[i] + ", ");
            } else {
                System.out.print(chars[i]);
            }
        }
        System.out.print("]\n");
    }

}
