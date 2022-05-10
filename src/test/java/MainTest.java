import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testEmptyStringInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""), "Zero length string");
    }
    
    @Test
    public void testRandomStringInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("Test test"), "For input string: \"Test test\"");
    }
    
    @Test
    public void testZeroInput() {
        Assertions.assertEquals(0, Integer.decode("+0"));
        Assertions.assertEquals(0, Integer.decode("0"));
        Assertions.assertEquals(0, Integer.decode("-0"));
    }
    
    @Test
    public void testMaxInput() {
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(Integer.MAX_VALUE + ""));
    }
    
    @Test
    public void testMinInput() {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(Integer.MIN_VALUE + ""));
    }
    
    @Test
    public void testPositiveNegativeInput() {
        Assertions.assertEquals(1, Integer.decode("+1"));
        Assertions.assertEquals(1, Integer.decode("1"));
        Assertions.assertEquals(-1, Integer.decode("-1"));
    }
    
    @Test
    public void testHexInput() {
        Assertions.assertEquals(17, Integer.decode("0x11"));
        Assertions.assertEquals(17, Integer.decode("0X11"));
        Assertions.assertEquals(17, Integer.decode("0x0011"));
        Assertions.assertEquals(-17, Integer.decode("-0x11"));
        Assertions.assertEquals(17, Integer.decode("#11"));
        Assertions.assertEquals(-17, Integer.decode("-#11"));
    }
    
    @Test
    public void testPlusWrongPositionInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("1+2"), "Sign character in wrong position");
    }
    
    @Test
    public void testOctalInput() {
        Assertions.assertEquals(8, Integer.decode("010"));
        Assertions.assertEquals(-8, Integer.decode("-010"));
        Assertions.assertEquals(9, Integer.decode("011"));
        Assertions.assertEquals(-9, Integer.decode("-011"));
    }
}
