package search;/**
 * @author Weiyan Xiang on 2020/12/26
 */

import java.util.*;

public class WordLadder {
    /**
     * 127. Word Ladder
     * <p>
     * https://leetcode.com/problems/word-ladder/
     */
    public int ladderLengthBfs(String bw, String ew, List<String> wl) {
        // build dict
        Set<String> dict = new HashSet<>(wl);
        if (!wl.contains(ew)) return 0;
        // bfs
        int count = 0;
        LinkedList<String> queue = new LinkedList<>();
        int wordLen = bw.length();
        queue.add(bw);
        while (!queue.isEmpty()) {
            count++;
            int qs = queue.size();
            for (int ss = qs; ss > 0; ss--) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    char curChar = chs[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == curChar) continue;
                        chs[i] = j;
                        String uw = new String(chs);
                        if (uw.equals(ew)) return count + 1;
                        if (!dict.contains(uw)) continue;
                        dict.remove(uw);
                        queue.add(uw);
                    }
                    chs[i] = curChar;
                }
            }
        }
        return 0;
    }

    /**
     * bi-directional BFS
     */
    public int ladderLength(String bw, String ew, List<String> wl) {
        Set<String> dict = new HashSet<>(wl);
        if (!dict.contains(ew)) return 0;

        // 2 queues, 1 from beginning 1 from end
        Set<String> s1 = new HashSet<>();
        s1.add(bw);
        Set<String> s2 = new HashSet<>();
        s2.add(ew);

        int l = bw.length();
        int count = 0;

        while (!s1.isEmpty() && !s2.isEmpty()) {
            count++;
            // always switch to shorter one to do bfs
            if (s1.size() > s2.size()) {
                Set<String> temp = s1;
                s1 = s2;
                s2 = temp;
            }
            Set<String> curQ = new HashSet<>();
            for (String word : s1) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < l; i++) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) continue;
                        chs[i] = c;
                        String updatedWord = new String(chs);
                        // s2 contains the word meaning it connects to s1 which builds a valid path.
                        if (s2.contains(updatedWord)) return count + 1;
                        if (!dict.contains(updatedWord)) continue;
                        dict.remove(updatedWord);
                        curQ.add(updatedWord);
                    }
                    chs[i] = ch;
                }
            }
            s1 = curQ;
        }
        return 0;
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
        Set<String> v1 = new HashSet<>();
        Set<String> v2 = new HashSet<>();

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
                if (v1.contains(pass)) continue;
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
