package muc.java_class.second_homework.stringop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrOpTest {
    @Test
    public void testStrAppend() {
        assertEquals("hello hello hello ",
                StringOperation.stringAppend("hello ", 2));
        assertEquals("aaa",
                StringOperation.stringAppend("a", 2));
        assertEquals("happy",
                StringOperation.stringAppend("happy", 0));
    }

    @Test
    public void testStrCompress() {
        assertEquals("hel2o",
                StringOperation.stringCompress("hello"));
        assertEquals("unique",
                StringOperation.stringCompress("unique"));
        assertEquals("se2 a se2d",
                StringOperation.stringCompress("see a seed"));
        assertEquals("o5ps",
                StringOperation.stringCompress("ooooops"));
    }

    @Test
    public void testStrEncrypt() {
        assertEquals("xyz",
                StringOperation.stringEncryption("uvw", 3));
        assertEquals("abc",
                StringOperation.stringEncryption("uvw", 6));
        assertEquals("abc",
                StringOperation.stringEncryption("uvw", 32));
        String originalString = "Happy";
        String encryptedString = StringOperation.stringEncryption(originalString, 5);
        assertEquals(originalString,
                StringOperation.stringEncryption(encryptedString, 26 - 5));
    }
}
