package com.techelevator;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CigarPartyTest  {

    @Test

    public void testHaveParty30() {

        CigarParty cigar = new CigarParty();


        assertEquals(false, cigar.haveParty(30, false));
        assertEquals(false, cigar.haveParty(30, true));

    }


    @Test

    public void testHaveParty40() {

        CigarParty cigar = new CigarParty();

        assertEquals(true, cigar.haveParty(40, true));
        assertEquals(true, cigar.haveParty(40, false));

    }


    @Test

    public void testHaveParty50() {

        CigarParty cigar = new CigarParty();

        assertEquals(true, cigar.haveParty(50, false));

    }


    @Test

    public void testHaveParty60() {

        CigarParty cigar = new CigarParty();

        assertEquals(true, cigar.haveParty(60, false));

    }



    @Test

    public void testHaveParty70() {

        CigarParty cigar = new CigarParty();

        assertEquals(true, cigar.haveParty(70, true));
        assertEquals(false, cigar.haveParty(70, false));

    }


}