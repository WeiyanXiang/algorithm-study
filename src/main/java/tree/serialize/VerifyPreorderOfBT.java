package tree.serialize;/**
 * @author Weiyan Xiang on 2021/8/21
 */

import java.util.Stack;

public class VerifyPreorderOfBT {

    /**
     * 331. Verify Preorder Serialization of a Binary Tree
     * <p>
     * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
     * <p>
     * upvoted ans: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78560/Simple-Python-solution-using-stack.-With-Explanation.
     * basically, folding each sub-node, once folded, mark a "#".
     * <p>
     * The key here is, when you see two consecutive "#" characters on stack, pop both of them and replace the topmost
     * element on the stack with "#". For example,
     * <p>
     * preorder = 1,2,3,#,#,#,#
     * <p>
     * Pass 1: stack = [1]
     * <p>
     * Pass 2: stack = [1,2]
     * <p>
     * Pass 3: stack = [1,2,3]
     * <p>
     * Pass 4: stack = [1,2,3,#]
     * <p>
     * Pass 5: stack = [1,2,3,#,#] -> two #s on top so pop them and replace top with #. -> stack = [1,2,#]
     * <p>
     * Pass 6: stack = [1,2,#,#] -> two #s on top so pop them and replace top with #. -> stack = [1,#]
     * <p>
     * Pass 7: stack = [1,#,#] -> two #s on top so pop them and replace top with #. -> stack = [#]
     * <p>
     * If there is only one # on stack at the end of the string then return True else return False.
     */
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.length; i++) {
            String cur = list[i];
            if (cur.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
                stack.push("#"); // folded current sub-tree
            } else {
                stack.push(cur);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

}
