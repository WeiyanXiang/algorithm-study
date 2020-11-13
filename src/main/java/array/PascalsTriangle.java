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

    /**
     * https://leetcode.com/problems/pascals-triangle/submissions/
     */
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
     */
    //@formatter:on
    public List<List<Integer>> generateMyAnswer(int n) {
        if (n == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        if (n == 1) return res;
        for (int r = 0; r < n - 1; r++) {
            List<Integer> last = res.get(res.size() - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int i = 0; i < last.size() - 1; i++) {
                newRow.add(last.get(i) + last.get(i + 1));
            }
            newRow.add(1);
            res.add(newRow);
        }
        return res;
    }

    public static List<List<Integer>> generateOptimal(int n) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                // not easy to pick up, the reason why to enqueue row.get(j) + row.get(j + 1) rather
                // than row.get(j -1 ) + row.get(j ) is because we have a row.enqueue(0,1) in the
                // beginning
                row.set(j, row.get(j) + row.get(j + 1));
            }
            answer.add(new ArrayList<Integer>(row));
        }
        return answer;
    }

    public static void main(String[] args) {
        List<List<Integer>> answer = generateOptimal(5);
        List<List<Integer>> answerOptimal = generateOptimal(5);
        // here what we expect is to print the example output above.
        answer.forEach(System.out::println);
        System.out.println();
        answerOptimal.forEach(System.out::println);
    }

}
