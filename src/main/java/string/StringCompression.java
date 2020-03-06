package string;

/**
 * @author Weiyan Xiang on 2020/3/5
 */
public class StringCompression {

    public static int compress(char[] chars) {
        int currentCharNum = 1;
        int writeIndex = 0;
        if (chars.length == 1) {
            return 1;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                currentCharNum++;
                if (i == chars.length - 1) {
                    writeIndex = writeCompression(chars, currentCharNum, writeIndex, i);
                }
            } else {
                writeIndex = writeCompression(chars, currentCharNum, writeIndex, i);
                currentCharNum = 1;
                if (i == chars.length - 1) {
                    chars[writeIndex++] = chars[i];
                }
            }
        }
        return writeIndex;
    }

    public static char[] doCompress(char[] chars) {
        int currentCharNum = 1;
        int writeIndex = 0;
        if (chars.length == 1) {
            writeIndex++;
            return chars;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                currentCharNum++;
                if (i == chars.length - 1) {
                    writeIndex = writeCompression(chars, currentCharNum, writeIndex, i);
                }
            } else {
                writeIndex = writeCompression(chars, currentCharNum, writeIndex, i);
                currentCharNum = 1;
                if (i == chars.length - 1) {
                    chars[writeIndex++] = chars[i];
                }
            }
        }
        return chars;
    }


    private static int writeCompression(char[] chars, int currentCharNum, int writeIndex, int i) {
        chars[writeIndex++] = chars[i - 1];
        if (currentCharNum > 1) {
            char[] currentCharNumInChar = String.valueOf(currentCharNum).toCharArray();
            for (char element : currentCharNumInChar) {
                chars[writeIndex++] = element;
            }
            return writeIndex;
        }
        return writeIndex;
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
        chars = doCompress(chars);
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
