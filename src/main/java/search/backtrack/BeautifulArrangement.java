package search.backtrack;/**
 * @author Weiyan Xiang on 2021/1/25
 */

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {
    /**
     * 526. Beautiful Arrangement
     * <p>
     * https://leetcode.com/problems/beautiful-arrangement/
     * <p>
     * my own AC ans:
     */
    private int count = 0;

    public int countArrangement(int n) {
        dfs(n, new ArrayList<>());
        return count;
    }

    private void dfs(int n, List<Integer> cur) {
        if (cur.size() == n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (cur.contains(i)) continue;
            int targetIndex = cur.size() + 1;
            if (i % targetIndex == 0 || targetIndex % i == 0) {
                cur.add(i);
                dfs(n, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }


    /**
     * upvoted answer, using position and array to track visited
     */
    private int anotherCount = 0;

    public int countArrangementUsingArray(int n) {
        dfs(n, new int[n + 1], 1);
        return anotherCount;
    }

    private void dfs(int n, int[] used, int index) {
        if (index > n) {
            anotherCount++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i] != 0) continue;
            if (i % index == 0 || index % i == 0) {
                used[i] = 1;
                dfs(n, used, index + 1);
                used[i] = 0;
            }
        }
    }

}
