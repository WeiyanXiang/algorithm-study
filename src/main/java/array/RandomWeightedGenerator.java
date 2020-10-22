package array;

import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author Weiyan Xiang on 2020/10/22
 */
public class RandomWeightedGenerator {
    private int[] randomNums;
    private Random random;
    private TreeMap<Float, Integer> weightedMap;

    public RandomWeightedGenerator(int[] randomNums, float[] probabilities) {
        this(randomNums, probabilities, new Random());
    }

    protected RandomWeightedGenerator(int[] randomNums, float[] probabilities, Random random) {
        validateInputs(randomNums, probabilities);
        this.randomNums = randomNums;
        this.weightedMap = new TreeMap<>();
        this.random = random;
        initialiseWeightedMap(probabilities);
    }

    /**
     * @return one of the randomNums based on the given probabilities, scaled if sum of probabilities not 1.
     */
    public int nextNum() {
        return weightedMap.ceilingEntry(random.nextFloat()).getValue();
    }

    private void initialiseWeightedMap(float[] probabilities) {
        float sum = 0;
        for (float p : probabilities) sum += p;
        float scale = sum == 0 ? 1 : 1 / sum;

        float weight = 0f;
        for (int i = 0; i < randomNums.length; i++) {
            weight += probabilities[i];
            this.weightedMap.put(scale * weight, this.randomNums[i]);
        }
    }

    private void validateInputs(int[] randomNums, float[] probabilities) {
        Objects.requireNonNull(randomNums, ("randomNums should not be null"));
        Objects.requireNonNull(probabilities, ("probabilities should not be null"));
        for (float p : probabilities) {
            if (p < 0) throw new IllegalArgumentException("probability cannot be negative");
        }
        if (randomNums.length != probabilities.length)
            throw new IllegalArgumentException("Length of randomNums and probabilities are not equal.");
    }
}
