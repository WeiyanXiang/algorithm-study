package search;/**
 * @author Weiyan Xiang on 2021/1/9
 */

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    /**
     * 93. Restore IP Addresses
     * <p>
     * https://leetcode.com/problems/restore-ip-addresses/
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        dfs(s, list, "", 0, 0);
        return list;
    }

    private void dfs(String s, List<String> ans, String cur, int d, int start) {
        // important pruning d>4
        if (d > 4) return;
        if (d == 4 && start == s.length()) {
            ans.add(cur);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break;
            String section = s.substring(start, start + i);
            if (section.length() > 1 && section.startsWith("0")) break;
            if (Integer.valueOf(section) > 255) break;
            String updatedCur = d == 0 ? section : cur + "." + section;
            dfs(s, ans, updatedCur, d + 1, start + i);
        }
    }

    public List<String> restoreIpAddressesMyBacktrackVersion(String s) {
        // dfs string, if depth is 4 and index is last index, then return the ans
        // else, loop to find valid number and dfs for next index
        List<String> ans = new ArrayList<>();
        dfsBacktrack(s,ans,"",0,0);
        return ans;
    }

    private void dfsBacktrack(String s, List<String> ans, String cur, int depth, int start) {
        if(depth>4) return;
        if(depth==4 && start==s.length()) {
            ans.add(cur);
            return;
        }
        // up to 255 which is 3 digits
        for(int i=1;i<=3;i++){
            if(start+i>s.length()) return;
            String section = s.substring(start,start+i);
            if(section.length()>1 && section.startsWith("0")) return;
            if(Integer.valueOf(section) > 255) return;
            cur += (depth==0 ? "" : ".")+section;
            dfsBacktrack(s,ans,cur,depth+1,start+i);
            cur = depth == 0 ?
                    cur.substring(0,cur.length()-section.length()) :
                    cur.substring(0,cur.length()-section.length()-1);
        }
    }
}
