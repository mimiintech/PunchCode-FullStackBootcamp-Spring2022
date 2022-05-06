package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SameFirstLastTest {

    @Test
    public void testIsItTheSame1() {
        SameFirstLast same = new SameFirstLast();
        assertEquals(false, same.isItTheSame(new int[]{1, 2, 3}));
    }

    @Test
    public void testIsItTheSame2() {
        SameFirstLast same = new SameFirstLast();
        assertEquals(true, same.isItTheSame(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void testIsItTheSame3() {
        SameFirstLast same = new SameFirstLast();
        assertEquals(true, same.isItTheSame(new int[]{1, 2, 1}));
    }
}