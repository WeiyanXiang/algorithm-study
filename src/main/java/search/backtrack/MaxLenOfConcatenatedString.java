package search.backtrack;/**
 * @author Weiyan Xiang on 2021/2/10
 */

import java.util.List;

public class MaxLenOfConcatenatedString {
    private int count = 0;

    public int maxLength(List<String> arr) {
        boolean[] visited = new boolean[26];
        dfs(arr, visited, 0, "");
        return count;
    }

    private void dfs(List<String> arr, boolean[] visited, int start, String cur) {
        if (isUnique(cur, visited)) {
            count++;
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            String word = arr.get(i);
            for (int j = 0; j < word.length(); j++) {
                visited[word.charAt(j) - 'a'] = true;
            }
            dfs(arr, visited, i + 1, cur + arr.get(i));
            for (int c = 0; c < word.length(); c++) {
                visited[word.charAt(c) - 'a'] = false;
            }
        }
    }

    private boolean isUnique(String cur, boolean[] visited) {
        for (int i = 0; i < cur.length(); i++) {
            if (visited[cur.charAt(i) - 'a']) return false;
        }
        return true;
    }
}
