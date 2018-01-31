/**
 * 
 */
package string;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class CountTripletsLessThanInput {
    public static int countTriplets(int[] array, int value) {
        Arrays.sort(array);
        int n = array.length;
        if (n < 3)
            return 0;
        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            // Initialize other two elements as corner elements
            // of subarray arr[j+1..k]
            int j = i + 1, k = n - 1;
            // Use Meet in the Middle concept
            while (j < k) {
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (array[i] + array[j] + array[k] >= value) {
                    k--;
                } else {
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    answer += k - j;
                    j++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 5, 1, 3, 4, 7 };
        int[] anotherTest = new int[] { -2, 0, 1, 3 };
        System.out.println("count { 5, 1, 3, 4, 7 } triplet with given value 12 is: 4 = " + countTriplets(test, 12));
        System.out.println("count  {-2, 0, 1, 3} triplet with given value 2 is: 2 = " + countTriplets(anotherTest, 2));
    }
}
