package muc.java_class.second_homework.stringoperator;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class StringOperatorTest {
    public static StringOperator stringOperator = new StringOperator();//初始化

    @Test
    void testCheckPwd() {
        assertEquals("A3tx2z5w@", StringOperator.checkPwd("A3tx2z5w@"));
        assertEquals("Hello18>?", StringOperator.checkPwd("Hello18>?"));
        assertEquals("A3dj*fkd", StringOperator.checkPwd("A3dj*fkd"));
        assertEquals("ARCshina78[", StringOperator.checkPwd("ARCshina78["));

    }

    @Test
    void testCryptPwd() {
        assertEquals("1xxx?5!aaaaaK", StringOperator.cryptPwd("12x?5!4aK"));
        assertEquals("Attttxzzzwwwwww@", StringOperator.cryptPwd("A3tx2z5w@"));
        assertEquals("arcadoif19L", StringOperator.cryptPwd("arcadoif190L"));
        assertEquals("Onelastkkkkkis~", StringOperator.cryptPwd("Onelast4kis~"));

    }

    @Test
    void testmachPwd() {

        assertEquals(false, StringOperator.matchInput("Hello18>?"));
        assertEquals(true, StringOperator.matchInput("Onelast4kis~"));
        assertEquals(true, StringOperator.matchInput("arcadoif190L"));
        assertEquals(false, StringOperator.matchInput("570abc>/G"));

    }

}
