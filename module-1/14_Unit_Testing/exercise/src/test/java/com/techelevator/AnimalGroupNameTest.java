package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AnimalGroupNameTest {

    @Test

    public void testGetTower() {


//        Arrange

        AnimalGroupName animal = new AnimalGroupName();

//        Assert

        assertEquals("Tower", animal.getHerd("giraffe"));
        assertEquals("Tower", animal.getHerd("GiRaFfE"));

    }

    @Test

    public void testGetMurder() {


        AnimalGroupName animal = new AnimalGroupName();

        assertEquals("Murder",animal.getHerd("Crow"));
    }


    @Test

    public void testGetUnknown() {

        AnimalGroupName animal = new AnimalGroupName();

        assertEquals("unknown", animal.getHerd(""));
        assertEquals("unknown", animal.getHerd("walrus"));
        assertEquals("unknown", animal.getHerd(null));


    }
}