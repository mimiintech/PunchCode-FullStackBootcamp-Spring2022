package com.techelevator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Lucky13Tests  {

    @Test

   public void Null_ExpectTrue() {
//        Arrange
        Lucky13 lucky = new Lucky13();


//        Assert
        assertEquals(true, lucky.getLucky(null));

    }

    @Test
            public void ArrayWithNo1s3s_ExpectTrue() {

//        Arrange

        Lucky13 lucky = new Lucky13();

//        Assert

        assertEquals(true, lucky.getLucky(new int[]{0, 2, 4}));
        assertEquals(true, lucky.getLucky(new int[]{}));
    }

    @Test

    public void ArrayWithNo1s3s_ExpectFalse() {

////        Arrange

        Lucky13 lucky = new Lucky13();


//        //Assert
        assertEquals(false,lucky.getLucky(new int[] { 1,1,1 }));
        assertEquals(false,lucky.getLucky(new int[] { 3,3,3 }));
        assertEquals(false,lucky.getLucky(new int[] { 1,3}));

    }
}