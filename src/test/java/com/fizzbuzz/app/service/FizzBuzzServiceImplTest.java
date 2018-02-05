package com.fizzbuzz.app.service;

import com.fizzbuzz.app.model.FizzBuzzResponse;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author vanithadevig
 */
public class FizzBuzzServiceImplTest {

    private FizzBuzzServiceImpl fizzBuzzServiceImpl = new FizzBuzzServiceImpl();

    @Test
    public void testCalculateFizzBuzz() {

        List<Integer> buzzs = Lists.newArrayList(5,10,15);
        List<Integer> fizzs = Lists.newArrayList(3,6,9,12,15);
        List<Integer> fizzBuzzs = Lists.newArrayList(15);

        FizzBuzzResponse fizzBuzzResponse = fizzBuzzServiceImpl.calculateFizzBuzz(15);

        assertEquals(fizzBuzzResponse.getBuzzs().size(),3);
        assertTrue(fizzBuzzResponse.getBuzzs().containsAll(buzzs));
        assertEquals(fizzBuzzResponse.getFizzs().size(),5);
        assertTrue(fizzBuzzResponse.getFizzs().containsAll(fizzs));
        assertEquals(fizzBuzzResponse.getFizzbuzzs().size(),1);
        assertTrue(fizzBuzzResponse.getFizzbuzzs().containsAll(fizzBuzzs));
    }


}
