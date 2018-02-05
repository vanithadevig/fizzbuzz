package com.fizzbuzz.app.service;

import com.fizzbuzz.app.model.FizzBuzzResponse;

/**
 * {@link FizzBuzzService} is the interface which lists the method to calculate the
 * the FizzBuzz numbers.
 *
 * Design Pattern used : Composite
 *
 * Composite pattern would hide the implementation of the business logic to the client.
 *
 */

public interface FizzBuzzService {

    /**
     * <code>calculateFizzBuzz</code> has the logic to calculate the FizzBuzz numbers.
     *  For a <code>maxValue</code> ,
     *      numbers that are divisible by 3 would be in {@link FizzBuzzResponse}.fizzs
     *      numbers that are divisible by 5 would be in {@link FizzBuzzResponse}.buzzs
     *      numbers that are divisble by 3 & 5 would be in {@link FizzBuzzResponse}.fizzbuzzs
     *
     * @param maxValue - max value up to which the Fizz,Buzz,FizzBuzz numbers are to be determined
     *
     * @return {@link FizzBuzzResponse} object with Fizz,Buzz,FizzBuzz numbers
     */
    FizzBuzzResponse calculateFizzBuzz(final int maxValue);
}
