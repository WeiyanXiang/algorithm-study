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
			return new ArrayList<>();
		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				answer.add(Arrays.asList(1));
			} else {
				List<Integer> row = new ArrayList<>();
				row.add(1);
				int currentIndex = i - 2;
				List<Integer> previousRow = answer.get(currentIndex);
				for (int j = 0; j < previousRow.size() - 1; j++) {
					int subSum = previousRow.get(j) + previousRow.get(j + 1);
					row.add(subSum);
				}
				row.add(1);
				answer.add(row);
			}
		}
		return answer;
	}

	public static List<List<Integer>> generateOptimal(int n) {
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++) {
				// not easy to pick up, the reason why to add row.get(j) + row.get(j + 1) rather
				// than row.get(j -1 ) + row.get(j ) is because we have a row.add(0,1) in the
				// beginning
				row.set(j, row.get(j) + row.get(j + 1));
			}
			answer.add(new ArrayList<Integer>(row));
		}
		return answer;
	}

	public static void main(String[] args) {
		List<List<Integer>> answer = generate(5);
		List<List<Integer>> answerOptimal = generateOptimal(5);
		// here what we expect is to print the example output above.
		answer.forEach(System.out::println);
		System.out.println();
		answerOptimal.forEach(System.out::println);

	}

}
