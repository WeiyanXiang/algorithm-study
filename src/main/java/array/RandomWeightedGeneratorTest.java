package array;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * @author Weiyan Xiang on 2020/10/22
 */
public class RandomWeightedGeneratorTest {

    private Random random = new Random();
    private RandomWeightedGenerator testObj;

    @Test
    public void should_throw_exception_when_invalid_inputs() {
        int[] randomNums = {1, 2, 7, 8};
        float[] probabilities = {0.1f, 0.9f, 0.8f, 0.4f};
        float[] probabilitiesWithNegValue = {0.1f, 0.9f, 0.8f, -0.4f};
        int[] randomNumsWithDifLength = {1, 2, 7};

        assertNotNull(new RandomWeightedGenerator(randomNums, probabilities));
        assertThrows(NullPointerException.class, () -> new RandomWeightedGenerator(null, probabilities));
        assertThrows(NullPointerException.class, () -> new RandomWeightedGenerator(randomNums, null));
        assertThrows(NullPointerException.class, () -> new RandomWeightedGenerator(null, null));
        assertThrows(NullPointerException.class, () -> new RandomWeightedGenerator(null, null));
        assertThrows(IllegalArgumentException.class, () -> new RandomWeightedGenerator(randomNumsWithDifLength, probabilities));
        assertThrows(IllegalArgumentException.class, () -> new RandomWeightedGenerator(randomNums, probabilitiesWithNegValue));

    }

    @Test
    public void should_generate_random_num_as_per_scaled_weights() {
        // sum of probabilities is not 1, scaling in effect
        int[] randomNums = {1, 2, 7};
        float[] probabilities = {1f, 2f, 4f};
        random.setSeed(7);
        testObj = new RandomWeightedGenerator(randomNums, probabilities, random);
        Map<Integer, Integer> actual = new HashMap<>();
        Map<Integer, Integer> expected = ImmutableMap.of(1, 1415, 2, 2879, 7, 5706);
        // act
        IntStream.range(0, 10000).forEach(i -> actual.compute(testObj.nextNum(), (k, v) -> v == null ? 1 : v + 1));
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void should_generate_random_num_as_per_weights() {
        // sum of probabilities is 1
        int[] randomNums = {-1, 1, 2, 4};
        float[] probabilities = {0.1f, 0.2f, 0.3f, 0.4f};
        random.setSeed(5);
        testObj = new RandomWeightedGenerator(randomNums, probabilities, random);
        Map<Integer, Integer> actual = new HashMap<>();
        Map<Integer, Integer> expected = ImmutableMap.of(-1, 978, 1, 2010, 2, 2982, 4, 4030);
        // act
        IntStream.range(0, 10000).forEach(i -> actual.compute(testObj.nextNum(), (k, v) -> v == null ? 1 : v + 1));
        // assert
        assertEquals(expected, actual);
    }
}