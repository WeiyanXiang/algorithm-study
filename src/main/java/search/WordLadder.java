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
                        String updatedWord = new String(chs);
                        if (updatedWord.equals(ew)) return count + 1;
                        if (!dict.contains(updatedWord)) continue;
                        dict.remove(updatedWord);
                        queue.add(updatedWord);
                    }
                    chs[i] = curChar;
                }
            }
        }
        return 0;
    }


}
