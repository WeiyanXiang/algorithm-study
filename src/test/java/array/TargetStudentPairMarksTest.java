package array;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2022/1/9
 */
public class TargetStudentPairMarksTest {
    @Test
    public void testPairs() {
        TargetStudentPairMarks testObj = new TargetStudentPairMarks();
        List<List<String>> actual = testObj.getPairs(10, 150,
                asList("ron 50",
                        "harry 100",
                        "naruto 150",
                        "diego 0",
                        "tom 50",
                        "jerry 100",
                        "shika 90",
                        "tenten 60",
                        "sasuke 110",
                        "gara 114"));
        MatcherAssert.assertThat(actual, containsInAnyOrder(
                asList("ron", "harry"),
                asList("naruto", "diego"),
                asList("tom", "jerry"),
                asList("shika", "tenten")
        ));
    }
}