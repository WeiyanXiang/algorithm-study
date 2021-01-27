package search.backtrack;

/**
 * @author Weiyan Xiang on 2021/1/25
 */

public class BeautifulArrangementTwo {

    /**
     * 667. Beautiful Arrangement II
     * <p>
     * https://leetcode.com/problems/beautiful-arrangement-ii/
     *
     * upvoted ans
     *
     */
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int l = 1, r = n;
        for (int i = 0; i < n; i++) {
            // why k%2 == 0 ?
            /**
             * k = 1
             * {1, 2, 3, 4, 5, 6} OR {6, 5, 4, 3, 2, 1}.
             *
             * For k = 2
             * {1, 6, 5, 4, 3, 2} OR {6, 1, 2, 3, 4, 5}.
             *
             * For k = 3
             * {1, 6, 2, 3, 4, 5} OR {6, 1, 5, 4, 3, 2}.
             *
             * Notice that each time we want to increase k, we reverse the list again and again from list of size n - 1 to n - 2 to n - 3 to.....
             * Hence, to have a higher k, we just have to keep reversing the elements on top of each other from index 0 to index k - 1.
             */
            if (k % 2 == 0) {
                ans[i] = r--;
            } else {
                ans[i] = l++;
            }
            // if k is 1, keep adding l++ to ensure same dif, 1
            if (k > 1) {
                k--;
            }
        }
        return ans;
    }
}
