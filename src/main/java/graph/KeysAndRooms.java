package graph;/**
 * @author Weiyan Xiang on 2021/3/1
 */

import java.util.HashSet;
import java.util.List;

public class KeysAndRooms {
    /**
     * 841. Keys and Rooms
     *
     * https://leetcode.com/problems/keys-and-rooms/
     *
     * my ac ans
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // dfs find all rooms
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        return dfs(rooms, 0, set);
    }

    private boolean dfs(List<List<Integer>> rooms, int r, HashSet<Integer> set) {
        if (set.size() == rooms.size()) return true;
        List<Integer> row = rooms.get(r);
        for (int i = 0; i < row.size(); i++) {
            int nextRoom = row.get(i);
            if (set.contains(nextRoom)) continue;
            set.add(nextRoom);
            if (dfs(rooms, nextRoom, set)) return true;
        }
        return false;
    }
}
