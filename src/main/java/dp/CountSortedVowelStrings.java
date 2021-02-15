package dp;/**
 * @author Weiyan Xiang on 2021/2/15
 */

import java.util.*;

public class CountSortedVowelStrings {

    /**
     * 1641. Count Sorted Vowel Strings
     *
     * https://leetcode.com/problems/count-sorted-vowel-strings/
     *
     * upvoted dp ans:
     * TC O(n)
     * SC O(1)
     */
    public int countVowelStrings(int n) {
        // dp idea, a,e,i,o,u
        // for a: a e i o u can be put ahead
        // for e: e i o u can be put ahead
        // for i: i o u can be put ahead
        // for o: o u can be put ahead
        // for u: u can be put ahead
        int a=1,e=1,i=1,o=1,u=1;
        for(int x=0;x<n-1;x++){
            a=a+e+i+o+u;
            e=e+i+o+u;
            i=i+o+u;
            o=o+u;
        }
        return a+e+i+o+u;
    }
    /**
     * my dfs ac slow ans, TC: 5^n
     */
    private int count = 0;
    public int countVowelStringsDfs(int n) {
        // combination with resuable dict
        char[] chs = {'a','e','i','o','u'};
        dfs(n,chs,"",0);
        return count;
    }

    private void dfs(int n, char[] chs, String cur, int start){
        if(cur.length()==n) {
            count++;
            return;
        }
        for(int i=start;i<chs.length;i++){
            dfs(n,chs,cur+chs[i],i);
        }
    }
}
