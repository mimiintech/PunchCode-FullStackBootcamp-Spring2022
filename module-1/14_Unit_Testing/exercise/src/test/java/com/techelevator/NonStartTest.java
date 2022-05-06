package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class NonStartTest {

    @Test

    public void testGetPartialString3() {
        NonStart non = new NonStart();
        assertEquals("ellohere", non.getPartialString("Hello", "There"));
        assertEquals("avaode", non.getPartialString("java", "code"));
        assertEquals("hotlava", non.getPartialString("shotl", "java"));
    }

    @Test

    public void testGetPartialString6() {
        NonStart non = new NonStart();
        assertEquals("by", non.getPartialString("ab", "xy"));
        assertEquals("b", non.getPartialString("ab", "x"));
        assertEquals("c", non.getPartialString("x", "ac"));
    }

    @Test

    public void testGetPartialString9() {
        NonStart non = new NonStart();
        assertEquals("", non.getPartialString("a", "x"));
        assertEquals("itat", non.getPartialString("kit", "kat"));
        assertEquals("artart", non.getPartialString("mart", "dart"));

    }
}