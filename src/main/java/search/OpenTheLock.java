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


    public int openLockMyVersion(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        int depth = -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while (!q.isEmpty()) {
            depth++;
            for (int qq = q.size(); qq > 0; qq--) {
                String poll = q.poll();
                if (poll.equals(target)) return depth;
                if (deads.contains(poll)) continue;
                if (visited.contains(poll)) continue;
                visited.add(poll);
                // build all possible updates from current polled digits
                char[] chs = poll.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char ch = chs[i];
                    chs[i] = ch == '9' ? '0' : (char) (ch + 1);
                    String s1 = new String(chs);
                    q.offer(s1);
                    chs[i] = ch == '0' ? '9' : (char) (ch - 1);
                    String s2 = new String(chs);
                    q.offer(s2);
                    chs[i] = ch;
                }
            }
        }
        return -1;
    }


    /**
     * Bi-directional BFS, optimal
     */
    public int openLockMyVersionBiDirectionalBFS(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (deads.contains(start)) return -1;
        if (start.equals(target)) return 0;
        Set<String> q1 = new HashSet<>();
        q1.add(start);
        Set<String> q2 = new HashSet<>();
        q2.add(target);
        Set<String> visited = new HashSet<>();

        int depth = -1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            depth++;
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> tempQ = new HashSet<>();
            for (String pass : q1) {
                if (q2.contains(pass)) return depth;
                if (deads.contains(pass)) continue;
                if (visited.contains(pass)) continue;
                char[] chs = pass.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char ch = chs[i];
                    chs[i] = ch == '9' ? '0' : (char) (ch + 1);
                    String uw1 = new String(chs);
                    chs[i] = ch == '0' ? '9' : (char) (ch - 1);
                    String uw2 = new String(chs);
                    chs[i] = ch;
                    tempQ.add(uw1);
                    tempQ.add(uw2);
                }
            }
            q1 = tempQ;
        }
        return -1;
    }

}
