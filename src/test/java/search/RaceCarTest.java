package search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Weiyan Xiang on 2021/1/2
 */
public class RaceCarTest {

    @Test
    public void racecarMyVersion() {
        RaceCar testObj = new RaceCar();
        // act
        assertEquals(24, testObj.racecarMyVersion(330));
    }
}