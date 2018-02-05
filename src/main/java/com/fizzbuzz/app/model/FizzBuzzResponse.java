package com.fizzbuzz.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


/**
 * {@link FizzBuzzResponse} is the model Object for FizzBussService.
 *
 * @author vanithadevig
 */

public class FizzBuzzResponse {

    @JsonProperty("Fizz")
    private List<Integer> fizzs=new ArrayList<>();
    @JsonProperty("Buzz")
    private List<Integer> buzzs=new ArrayList<>();
    @JsonProperty("FizzBuzz")
    private List<Integer> fizzbuzzs=new ArrayList<>();


    public FizzBuzzResponse() {
    }

    public List<Integer> getFizzs() {
        return fizzs;
    }

    public void setFizzs(List<Integer> fizzs) {
        this.fizzs = fizzs;
    }

    public List<Integer> getBuzzs() {
        return buzzs;
    }

    public void setBuzzs(List<Integer> buzzs) {
        this.buzzs = buzzs;
    }

    public List<Integer> getFizzbuzzs() {
        return fizzbuzzs;
    }

    public void setFizzbuzzs(List<Integer> fizzbuzzs) {
        this.fizzbuzzs = fizzbuzzs;
    }

    @Override
    public String toString() {
        return "FizzBuzzResponse{" +
                "fizzs=" + fizzs +
                ", buzzs=" + buzzs +
                ", fizzbuzzs=" + fizzbuzzs +
                '}';
    }
}
