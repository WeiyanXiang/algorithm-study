package array;/**
 * @author Weiyan Xiang on 2021/12/21
 */

import java.util.*;

public class InvalidTransactions {
    /**
     * https://leetcode.com/problems/invalid-transactions/
     * <p>
     * no real algo required, just use a map to save and then loop through
     */
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<String[]>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (String t : transactions) {
            String[] ts = t.split(",");
            map.putIfAbsent(ts[0], new ArrayList<>());
            map.get(ts[0]).add(ts);
        }

        for (String t : transactions) {
            String[] ts = t.split(",");
            if (Integer.valueOf(ts[2]) > 1000) {
                ans.add(t);
                continue;
            }
            for (String[] curr : map.get(ts[0])) {
                if (Math.abs(Integer.parseInt(ts[1]) - Integer.parseInt(curr[1])) <= 60 && !ts[3].equals(curr[3])) {
                    ans.add(t);
                    break;
                }
            }
        }
        return ans;
    }
}
