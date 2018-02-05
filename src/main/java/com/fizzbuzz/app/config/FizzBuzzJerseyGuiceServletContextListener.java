package com.fizzbuzz.app.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * {@link FizzBuzzJerseyGuiceServletContextListener} is created to inject the Singleton objects
 * during the App deployment
 *
 * @author vanithadevig
 *
 */
public class FizzBuzzJerseyGuiceServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServiceModule(), new RestModule());
    }

}
