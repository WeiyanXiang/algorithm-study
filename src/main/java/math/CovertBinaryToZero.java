package math;

/**
 * @author Weiyan Xiang on 2020/9/30
 *
 * String S contains the binary representation of value V and we need to calculate number of operations after which this value becomes zero. There are 2 operations to perform:
 *
 * if V is even divide by 2
 * if V is odd subtract by 1
 * For example if S = "111", the function should return 5. Explanation: String S encodes to number V = 7. It requires five operations:
 *
 * V = 7, which is odd: subtract 1 to obtain 6
 * V = 6, which is even: divide by 2 to obtain 3
 * V = 3, which is odd: subtract 1 to obtain 2
 * V = 2, which is even: divide by 2 to obtain 1
 * V = 1, which is odd: subtract 1 to obtain 0
 */
public class CovertBinaryToZero {
    public static int solution(String s) {
        int firstOneAt = s.indexOf("1");
        return firstOneAt == -1 ? 0
                : s.replace("0", "").length() + s.length() - firstOneAt - 1;
    }
}
