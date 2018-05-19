/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class PascalsTriangleTwo {
	//@formatter:off    
	/*
	 * Given a non-negative index k where k ¡Ü 33, return the kth index row of the Pascal's triangle.

		Note that the row index starts from 0.
		
		
		In Pascal's triangle, each number is the sum of the two numbers directly above it.
		
		Example:
		
		Input: 3
		Output: [1,3,3,1]
		Follow up:
		
		Could you optimize your algorithm to use only O(k) extra space?
	 */
	//@formatter:on  
	public static List<Integer> getRow(int n) {
		List<Integer> row = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++) {
				row.set(j, row.get(j) + row.get(j + 1));
			}
			row = new ArrayList<Integer>(row);
		}
		return row;
	}

	public static void main(String[] args) {
		List<Integer> answer = getRow(5);
		// here what we expect is to print the example output above.
		answer.forEach(System.out::println);
	}

}
