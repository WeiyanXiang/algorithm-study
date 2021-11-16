package array;

/**
 * @author Weiyan Xiang on 2021/11/16
 */

public class KthSmallestNumberInMultiplicationTable {
    //@formatter:off
    /**
     * 668. Kth Smallest Number in Multiplication Table
     * <p>
     * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
     * <p>
     * upvoted ans
     */
    /**
     * Introduction
     * Given a m x n multiplication table, we need to find the kth smallest number in that table, where 1 <= k <= m*n. But first, let's consider a different point-of-view: if we are given a number num where 1 <= num <= m*n, how do we find the number of numbers in the table smaller than num? As an example, consider the following table:
     *
     * m=5, n=4: 5 x 4 multiplication table
     *
     *    1  2  3  4  5
     * 1  1  2  3  4  5
     * 2  2  4  6  8  10       [ 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 6, 8, 8, 9, 10, 12, 12, 15, 16, 20 ]
     * 3  3  6  9  12 15
     * 4  4  8  12 16 20
     * Say we want to find how many numbers are smaller than 12 in the table. We can break up the problem further and check the columns (or rows): how many numbers in each column is smaller than 12? The more intuitive way is to count the number of numbers that are strictly smaller than 12. For example:
     *
     * m=5, n=4: 5 x 4 multiplication table
     *
     *    1  2  3  4  5
     * 1  1  2  3  4  5
     * 2  2  4  6  8  10       [ 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 6, 8, 8, 9, 10, 12, 12, 15, 16, 20 ]
     * 3  3  6  9  12 15                                                   ^
     * 4  4  8  12 16 20                                                   |
     *    v  v  v  v  v                                                    |
     *    4  4  3  2  2  --> 15  -------------------------------------------
     * Notice that, since we excluded 12 itself from the count, the final number that the total count points to will be the number just before 12. I.e., since we obtain 15 from the total count of numbers less than 12, we can assert that 12 is the 16th smallest number.
     *
     * Pseudocode:
     * counter = 0
     * for each column number i (there are m columns)
     *     for each row number j (there are n columns)
     * 	    check if i*j < num (12 in our example)
     * 		    counter = counter + 1 if so
     * num is the (counter+1)-th smallest number
     * This will work, but it is quite slow (rough time complexity is O(mn) here). We can do better by obtaining the expected number of numbers smaller than 12 in each column (i.e. determine what j should be) by rounding down 12 / i. Then, since there is only a maximum of n rows, we need to account for this upper limit.
     *
     * Pseudocode:
     * counter = 0
     * for each column number i (there are m columns)
     *     determine expected value of j: num / i, rounded down
     * 	counter = counter + (j, but n if j > n)
     * 	check if i*j is num
     * 		count = counter - 1 if so
     * num is the (counter+1)-th smallest number
     * The new time complexity is O(m), which will run much faster. One final optimisation is to do away with the strict checking and allow 12 itself to be included in the count:
     *
     * Pseudocode:
     * counter = 0
     * for each column number i (there are m columns)
     *     determine expected value of j: num / i, rounded down
     * 	counter = counter + (j, but n if j > n)
     * num is the (counter)-th smallest number
     * m=5, n=4: 5 x 4 multiplication table
     *
     *    1  2  3  4  5
     * 1  1  2  3  4  5
     * 2  2  4  6  8  10       [ 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 6, 8, 8, 9, 10, 12, 12, 15, 16, 20 ]
     * 3  3  6  9  12 15                                                           ^
     * 4  4  8  12 16 20                                                           |
     *    v  v  v  v  v                                                            |
     *    4  4  4  3  2  --> 17  ---------------------------------------------------
     * This excludes all numbers that are strictly greater than 12. Notice that 16 =/= 17; we obtained two different indexes since there are duplicate 12s. If k = 16, however, we would still need to return 12. This suggests that we need to accomodate for duplicate numbers by allowing counter >= k, provided that the number we obtain in the counterth index is equal to our target num.
     *
     * Binary Search
     * How does binary search fit into all of this? Continuing from the POV we are using (determining how many numbers are smaller than a given num), we now want to know: how we can obtain this num? For that, we can use binary search to give us numbers to check through. How does this work?
     *
     * num must be bounded; 1 <= num <= m*n. This is not to say that num must be in the table, rather, we can safely assume that the kth smallest number must fall in [1, m*n] since 1 <= k <= m*n.
     * We are able to derive exactly 2 cases: either counter >= k is satisfied and num could be the correct number that we're looking for, or counter >= k is not satisfied and num is smaller than the target number. This dichotomous nature of the conditional checking of num forms the basis of binary search, as we can discard/disregard one half of the search space based on this condition.
     * So, our implementation can be as follows:
     *
     * Obtain a number from the middle of the search space [1, m*n].
     * Check if this number fulfils counter >= k.
     * If so, our targer number must lie in the lower half of the search space.
     * Otherwise, our target number must lie in the upper half of the search space.
     * Shrink the search space accordingly, and iterate until our search space reduces to a single number.
     */
    //@formatter:on
    public int findKthNumber(int m, int n, int k) {
        // binary search to find a num
        // count the number of numbers that are smaller than num
        // We can do better by obtaining the expected number of numbers smaller than 12 in each column (i.e. determine what j should be) by rounding down 12 / i
        int lo = 0, hi = m * n;
        while (lo < hi) {
            int mid = (lo + hi) / 2, count = 0;
            for (int i = 1; i <= m; i++) {
                count += n < mid / i ? n : mid / i;
            }
            // inbound
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;

    }

}
