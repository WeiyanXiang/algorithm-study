package string;

/**
 * @author Weiyan Xiang on 2020/3/5
 * <p>
 * 443. String Compression
 *
 * <p>
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {


    public static int compress(char[] chars) {
        int writeIndex = 0, readIndex = 0;
        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }
            chars[writeIndex++] = currentChar;
            if (count != 1)
                for (char c : Integer.toString(count).toCharArray())
                    chars[writeIndex++] = c;
        }
        return writeIndex;
    }

    // sliding window for each compress
    public int compressMyOwn(char[] chars) {
        int wi = 0, ri = 0;
        while (ri < chars.length) {
            char c = chars[ri];
            int count = 1;
            while (ri + 1 < chars.length && chars[ri] == chars[ri + 1]) {
                ri++;
                count++;
            }
            ri++;
            chars[wi++] = c;
            if (count != 1) {
                for (char cc : Integer.toString(count).toCharArray()) chars[wi++] = cc;
            }
        }
        return wi;
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
