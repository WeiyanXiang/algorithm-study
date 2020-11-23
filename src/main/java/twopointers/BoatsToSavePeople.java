package twopointers;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/11/23
 */
public class BoatsToSavePeople {
    /**
     * 881. Boats to Save People
     * <p>
     * https://leetcode.com/problems/boats-to-save-people/
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int count = 0;
        while (l <= r) {
            int minLeft = limit - people[r];
            if (minLeft >= people[l]) l++;
            count++;
            r--;
        }
        return count;
    }
}
