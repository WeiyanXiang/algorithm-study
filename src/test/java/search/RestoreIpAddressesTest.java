package search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Weiyan Xiang on 2021/1/9
 */
public class RestoreIpAddressesTest {

    @Test
    public void restoreIpAddresses() {
        RestoreIpAddresses testObj = new RestoreIpAddresses();
        // act
        List<String> actual = testObj.restoreIpAddresses("25525511135");
        // assert
        assertEquals(2, actual.size());
        assertTrue(actual.containsAll(Arrays.asList("255.255.11.135", "255.255.111.35")));
    }
}