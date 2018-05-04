/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weiyan.xiang
 * @date 19 Apr 2018
 */
public class PascalsTriangle {

	//@formatter:off    
    /**Given numRows, generate the first numRows of Pascal's triangle.

        For example, given numRows = 5,
        Return
        
        [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
        ]
     * 
     * @param numRows
     * @return
     */
    //@formatter:on
	public static List<List<Integer>> generate(int n) {
		if (n == 0)
			return null;
		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				answer.add(Arrays.asList(1));
			} else {
				if (i == 2) {
					answer.add(Arrays.asList(1, 1));
				} else {
					List<Integer> row = new ArrayList<>();
					row.add(1);
					for (int j = 0; j < answer.get(i - 1).size() - 1; j++) {
						int subSum = answer.get(i - 1).get(j) + answer.get(i - 1).get(j);
						row.add(subSum);
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		List<List<Integer>> answer = generate(5);
		// here what we expect is to print the example output above.
		answer.forEach(System.out::println);

	}

}
