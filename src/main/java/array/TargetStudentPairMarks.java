package array;/**
 * @author Weiyan Xiang on 2022/1/8
 */

import javafx.util.Pair;

import java.util.*;

public class TargetStudentPairMarks {
    /**
     * . Given a data set of N students with their names and marks. Find and arrange the students in pairs such that a
     * pairs marks add upto a given total d.
     * <p>
     * Note that a student can pair with only one other student, and when multiple pairs are possible the pairs are
     * formed with students who come earlier in the order of input.At least one pair will always be possible.
     * <p>
     * Contraints 3<= N <500 1<= length of names <=20
     * <p>
     * Input Format The first line of input consists of two integer n and d, where n is the number of students and d is
     * the requires total. Next n lines each consists of a string and a number,the student's name and marks.
     * <p>
     * Output Format Print only names of all possible pairs , one pair in each line. Pairs should be printed in the
     * order of input.
     * <p>
     * Sample Input: 10 150 ron 50 harry 100 naruto 150 diego 0 tom 50 jerry 100 shika 90 tenten 60 sasuke 110 gara 114
     * <p>
     * Output: ron harry, naruto diego, tom jerry, shika tenten
     */

    public List<List<String>> getPairs(int n, int target, List<String> studentsWithMarks) {
        Map<Integer, LinkedList<String>> map = new LinkedHashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String ss : studentsWithMarks) {
            String[] s = ss.split(" ");
            Integer mark = Integer.valueOf(s[1]);
            if (map.containsKey(mark)) {
                map.get(mark).offer(s[0]);
            } else {
                LinkedList<String> queue = new LinkedList<>();
                queue.offer(s[0]);
                map.put(mark, queue);
            }
        }
        // now map with points and names
        for (int i : map.keySet()) {
            while (map.containsKey(target - i) && !map.get(i).isEmpty() && !map.get(target - i).isEmpty()) {
                ans.add(Arrays.asList(map.get(i).poll(), map.get(target - i).poll()));
            }
        }
        return ans;
    }

}
