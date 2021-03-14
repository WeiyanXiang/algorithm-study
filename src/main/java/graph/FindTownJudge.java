package graph;

/**
 * @author Weiyan Xiang on 2021/3/14
 */

public class FindTownJudge {
    /**
     * 997. Find the Town Judge
     * <p>
     * https://leetcode.com/problems/find-the-town-judge/
     * <p>
     * upvoted ans, my own ans is bruce force though it is ac too.
     */
    public int findJudge(int N, int[][] trust) {
        // inbound - outbound = N-1 should be judge as inbound max is N-1 and outbound min is 0
        int[] arr = new int[N + 1];
        int count = 0;
        for (int[] t : trust) {
            arr[t[0]]--;
            arr[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (arr[i] == N - 1) return i;
        }
        return -1;
    }

    public int findJudgeBF(int N, int[][] trust) {
        int count = 0, ans = -1;
        for (int i = 1; i <= N; i++) {
            if (isJudge(i, trust, N) && count == 0) {
                count++;
                ans = i;
            }
        }
        return count == 1 ? ans : -1;
    }

    private boolean isJudge(int cur, int[][] trust, int N) {
        int count = 0;
        for (int[] t : trust) {
            if (t[0] == cur) return false;
            if (t[1] == cur) count++;
        }
        return count == N - 1;
    }
}
