package com.techelevator;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Less20Test {


    @Test

    public void testIsLessThanMultipleOf20() {

//        Arrange
            Less20 less = new Less20();


//        Assert
        assertEquals(true, less.isLessThanMultipleOf20(18));
        assertEquals(true, less.isLessThanMultipleOf20(19));

//        assertEquals(true, lucky.getLucky(new int[]{0, 2, 4}));
//        assertEquals(true, lucky.getLucky(new int[]{}));

        }

        @Test
        public void testIsMoreThanMultipleOf20() {

//        Arrange
            Less20 less = new Less20();

//        Assert
            assertEquals(true, less.isLessThanMultipleOf20(38));
            assertEquals(true, less.isLessThanMultipleOf20(39));

        }

            @Test
    public void testIsEqualToMultipleOf20() {

//        Arrange
                Less20 less = new Less20();

//                Assert
                assertEquals(false, less.isLessThanMultipleOf20(20));
                assertEquals(false, less.isLessThanMultipleOf20(40));

        }

        @Test
    public void testIsNotCloseToMultipleOf20() {

//        Arrange
            Less20 less = new Less20();

//            Assert
            assertEquals(false, less.isLessThanMultipleOf20(21));
            assertEquals(false, less.isLessThanMultipleOf20(41));
        }
    }