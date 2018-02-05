package com.fizzbuzz.app.service;

import com.fizzbuzz.app.model.FizzBuzzResponse;
import com.fizzbuzz.app.rest.FizzBuzzRS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Implementation of {@link FizzBuzzService}
 *
 * @author vanithadevig
 */
public class FizzBuzzServiceImpl implements FizzBuzzService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzServiceImpl.class);

    private static final int FIZZ_NUMBER = 3;

    private static final int BUZZ_NUMBER = 5;

    private static final int FIZZBUZZ_NUMBER = 15;

    @Override
    public FizzBuzzResponse calculateFizzBuzz(int maxValue) {
        FizzBuzzResponse fizzBuzzResponse = new FizzBuzzResponse();
        IntStream.rangeClosed(1,maxValue).forEach(i -> {
            if(i % FIZZBUZZ_NUMBER == 0) {
                fizzBuzzResponse.getFizzs().add(i);
                fizzBuzzResponse.getBuzzs().add(i);
                fizzBuzzResponse.getFizzbuzzs().add(i);
            } else if (i % FIZZ_NUMBER == 0) {
                fizzBuzzResponse.getFizzs().add(i);
            } else if (i % BUZZ_NUMBER == 0) {
                fizzBuzzResponse.getBuzzs().add(i);
            }
        });
        LOGGER.debug("generated fizzBuzz: {}", fizzBuzzResponse.toString());
        return fizzBuzzResponse;
    }
}
