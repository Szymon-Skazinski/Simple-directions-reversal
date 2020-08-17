package com.company;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void shouldReturnInvertedListOfOneWordStreet() {

        // given
        Solution solution = new Solution();

        // when

        String[] result = solution.solve(new String[]{"Begin on Road A","Right on Road B","Right on Road C","Left on Road D"});

        // then

        assertArrayEquals(result,new String [] {"Begin on Road D", "Right on Road C", "Left on Road B", "Left on Road A"});

    }

    @Test
    public void shouldReturnInvertedListOfMultiWordStreet() {

        // given
        Solution solution = new Solution();

        // when

        String[] result = solution.solve(new String[]{"Begin on 9th Dr", "Right on First Road", "Left on 3rd Blvd"});

        // then

        assertArrayEquals(result,new String []  {"Begin on 3rd Blvd", "Right on First Road", "Left on 9th Dr"});

    }

}


