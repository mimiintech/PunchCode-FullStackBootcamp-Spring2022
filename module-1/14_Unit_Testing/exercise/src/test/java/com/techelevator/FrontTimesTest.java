package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class FrontTimesTest  {

    @Test

    public void testGenerateString0() {

        FrontTimes front = new FrontTimes();
        assertEquals("", front.generateString("Abc", 0));
    }

    @Test

    public void testGenerateString2() {

        FrontTimes front = new FrontTimes();
        assertEquals("ChoCho", front.generateString("Chocolate", 2));
        assertEquals("", front.generateString("Abc", 0));
    }

    @Test

    public void testGenerateString3() {
        FrontTimes front = new FrontTimes();
        assertEquals("ChoChoCho", front.generateString("Chocolate", 3));
        assertEquals("AbcAbcAbc", front.generateString("Abc", 3));

    }

    @Test

    public void testGenerateString4() {
        FrontTimes front = new FrontTimes();
        assertEquals("AbAbAbAb", front.generateString("Ab", 4));
        assertEquals("AAAA", front.generateString("A", 4));
        assertEquals("", front.generateString("", 4));

    }
}