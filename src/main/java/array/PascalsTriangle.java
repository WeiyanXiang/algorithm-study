/**
 * 
 */
package array;

import java.util.ArrayList;
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
		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {

		}
		return null;
	}

	public static void main(String[] args) {
		List<List<Integer>> answer = generate(5);
		// here what we expect is to print the example output above.
		answer.forEach(System.out::println);

	}

}
