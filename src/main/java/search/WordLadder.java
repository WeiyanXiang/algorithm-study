package search;/**
 * @author Weiyan Xiang on 2020/12/26
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        queue.add(bw);
        while (!queue.isEmpty()) {
            count++;
            int qs = queue.size();
            for (int ss = qs; ss > 0; ss--) {
                String cur = queue.poll();
                StringBuilder sb = new StringBuilder();
                sb.append(cur);
                for (int i = 0; i < cur.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == cur.charAt(i)) continue;
                        sb.setCharAt(i, j);
                        String updatedCur = sb.toString();
                        if (updatedCur.equals(ew)) return count + 1;
                        if (!dict.contains(updatedCur)) continue;
                        dict.remove(updatedCur);
                        queue.push(updatedCur);
                    }
                    sb.setCharAt(i, cur.charAt(i));
                }
            }
        }
        return 0;
    }

    public int ladderLength(String bw, String ew, List<String> wl) {
        // build dict
        Set<String> dict = new HashSet<>(wl);
        if (!wl.contains(ew)) return 0;
        // bfs
        int count = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.add(bw);
        while (!queue.isEmpty()) {
            count++;
            int qs = queue.size();
            for (int ss = qs; ss > 0; ss--) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char curChar = chs[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == chs[i]) continue;
                        chs[i] = j;
                        String updatedWord = new String(chs);
                        if (updatedWord.equals(ew)) return count + 1;
                        if (!dict.contains(updatedWord)) continue;
                        dict.remove(updatedWord);
                        queue.push(updatedWord);
                    }
                    chs[i] = curChar;
                }
            }
        }
        return 0;
    }


}
