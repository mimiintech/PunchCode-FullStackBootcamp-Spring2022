package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class WordCountTest {

    WordCount wordCount = new WordCount();
    @Test
    public void return_number_of_times_value_is_repeated() {

        String[] var1 = {"ba", "ba", "black", "sleep"};

        Map<String, Integer> actual = wordCount.getCount(var1);

        Map<String, Integer> expected = new HashMap<>();

        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);


        Assert.assertEquals(expected.get("ba"),actual.get("ba"));
    }


    @Test
    public void return_number_of_times_value_is_repeated_again() {

        String[] var1 = {"a", "b", "c"};

        Map<String, Integer> actual = wordCount.getCount(var1);

        Map<String, Integer> expected = new HashMap<>();

        expected.put("a", 2);
        expected.put("b", 1);
        expected.put("c", 1);
    }
}