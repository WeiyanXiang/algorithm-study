package data.structure.queue;/**
 * @author Weiyan Xiang on 2021/11/14
 */

import java.util.Stack;

public class AsteroidCollision {

    /**
     * 735. Asteroid Collision
     * <p>
     * https://leetcode.com/problems/asteroid-collision/
     * <p>
     * upvoted ans: using a stack
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {
                s.push(i);
            } else {// i is negative
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)) {
                    s.pop();
                }
                if (s.isEmpty() || s.peek() < 0) {
                    s.push(i);
                } else if (i + s.peek() == 0) {
                    s.pop(); //equal
                }
            }
        }
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}
