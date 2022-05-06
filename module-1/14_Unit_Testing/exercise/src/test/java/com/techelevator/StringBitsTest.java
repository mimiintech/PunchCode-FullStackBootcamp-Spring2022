package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class StringBitsTest {

    @Test
    public void testGetBits2() {
        StringBits string = new StringBits();
        assertEquals("Hlo", string.getBits("Hello"));
        assertEquals("H", string.getBits("Hi"));
    }

    @Test
    public void testGetBits4() {
        StringBits string = new StringBits();
        assertEquals("Hello", string.getBits("Heeololeo"));
        assertEquals("HHH", string.getBits("HiHiHi"));
    }

    @Test
    public void testGetBits6() {
        StringBits string = new StringBits();
        assertEquals("", string.getBits(""));
        assertEquals("Getns", string.getBits("Greetings"));
    }

    @Test
    public void testGetBits8() {
        StringBits string = new StringBits();

        assertEquals("Coot", string.getBits("Chocoate"));
        assertEquals("p", string.getBits("pi"));
    }

    @Test
    public void testGetBits10() {
        StringBits string = new StringBits();

        assertEquals("HloKte", string.getBits("Hello Kitten"));
        assertEquals("happy", string.getBits("hxaxpxpxy"));
    }
}