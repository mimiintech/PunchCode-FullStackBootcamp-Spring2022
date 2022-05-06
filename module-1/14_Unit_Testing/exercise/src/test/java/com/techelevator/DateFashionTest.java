package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DateFashionTest {

    @Test
    public void testGetATable0() {
        DateFashion date = new DateFashion();
        assertEquals(0, date.getATable(2, 10));
        assertEquals(0, date.getATable(10, 1));
        assertEquals(0, date.getATable(5, 2));
        assertEquals(0, date.getATable(2, 2));
    }

    @Test
    public void testGetATable1() {
        DateFashion date = new DateFashion();
        assertEquals(1, date.getATable(5, 5));
    }

    @Test
    public void testGetATable2() {
        DateFashion date = new DateFashion();
        assertEquals(2, date.getATable(5, 10));
        assertEquals(2, date.getATable(10, 5));
        assertEquals(2, date.getATable(8, 8));
    }
}