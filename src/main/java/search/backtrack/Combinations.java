package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/21
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     * 77. Combinations
     * <p>
     * https://leetcode.com/problems/combinations/
     * <p>
     * very similar to CombinationSum 1 2 and 3
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // start from value 1
        dfs(n, k, ans, temp, 1);
        return ans;
    }

    private void dfs(int n, int k, List<List<Integer>> ans, List<Integer> temp, int start) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            dfs(n, k, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
