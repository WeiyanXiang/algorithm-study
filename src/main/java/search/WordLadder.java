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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);
        if (!dict.contains(endWord)) return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            ++steps;
            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            Set<String> q = new HashSet<>();
            for (String w : q1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) continue;
                        chs[i] = c;
                        String t = new String(chs);
                        if (q2.contains(t)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }
            q1 = q;
        }
        return 0;
    }


}
