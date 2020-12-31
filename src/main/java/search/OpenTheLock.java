package search;/**
 * @author Weiyan Xiang on 2020/12/31
 */

import java.util.*;

public class OpenTheLock {
    /**
     * 752. Open the Lock
     * <p>
     * https://leetcode.com/problems/open-the-lock/
     */
    public int openLock(String[] deadends, String target) {
        // build dict
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // bfs
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        int depth = -1;
        while (!queue.isEmpty()) {
            depth++;
            for (int q = queue.size(); q > 0; q--) {
                String poll = queue.poll();
                if (poll.equals(target)) return depth;
                if (deads.contains(poll)) continue;
                if (visited.contains(poll)) continue;
                visited.add(poll);
                queue.addAll(getAllPossibleUpdates(poll));
            }
        }
        return -1;
    }

    private List<String> getAllPossibleUpdates(String str) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            ans.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1) + str.substring(i + 1));
            ans.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1) + str.substring(i + 1));
        }
        return ans;
    }

}
