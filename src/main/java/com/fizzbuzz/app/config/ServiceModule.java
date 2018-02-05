package com.fizzbuzz.app.config;

import com.fizzbuzz.app.service.FizzBuzzService;
import com.fizzbuzz.app.service.FizzBuzzServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;


/**
 * {@link ServiceModule} is a custom class to bind all the Service class to its implementation.
 *
 * Design Pattern used : Singleton Pattern.
 *
 * To make sure that only one instance of the Service object is created and available for all
 * API calls.
 *
 * @author vanithadevig
 *
 */
public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FizzBuzzService.class).to(FizzBuzzServiceImpl.class).in(Scopes.SINGLETON);
    }
}
