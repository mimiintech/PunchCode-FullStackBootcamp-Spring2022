package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MaxEnd3Test {
    @Test
    public void testMakeArray1() {
        MaxEnd3 max = new MaxEnd3();
        assertArrayEquals(new int[]{3, 3, 3}, max.makeArray(new int[]{1, 2, 3}));
    }

    @Test
    public void testMakeArray11() {
        MaxEnd3 max = new MaxEnd3();
        assertArrayEquals(new int[]{11, 11, 11}, max.makeArray(new int[]{11, 5, 9}));
    }

    @Test
    public void testMakeArray2() {
        MaxEnd3 max = new MaxEnd3();
        assertArrayEquals(new int[]{3, 3, 3}, max.makeArray(new int[]{2, 11, 3}));

    }
}
