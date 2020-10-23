package knowledge.enumpractice;

import org.junit.Test;

import static knowledge.enumpractice.MainFoodType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * @author Weiyan Xiang on 2020/10/23
 */
public class MainFoodTypeTest {

    @Test
    public void should_validate_correct_enum() {
        assertEquals(RICE, getMainFoodType("rice"));
        assertEquals(NOODLE, getMainFoodType("noodle"));
        assertEquals(PASTA, getMainFoodType("pasta"));
        assertThrows(IllegalArgumentException.class, () -> getMainFoodType("INVALID"));
    }

}