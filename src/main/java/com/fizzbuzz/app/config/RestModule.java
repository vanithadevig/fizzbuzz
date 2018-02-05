package com.fizzbuzz.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link RestModule} extends {@link JerseyServletModule} is a Guice module that configures
 * the appropriate JAX-RS resources with Jersey Servlet and serves them under a given path.
 *
 * @author vanithadevig
 */
public final class RestModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        Map<String, String> initParams = new HashMap<>();
        initParams.put(PackagesResourceConfig.PROPERTY_PACKAGES, "com.fizzbuzz.app.rest");
        serve("/*").with(GuiceContainer.class, initParams);
    }

    @Provides
    @Singleton
    protected JacksonJsonProvider getJacksonJsonProvider(ObjectMapper objectMapper) {
        return new JacksonJsonProvider(new ObjectMapper());
    }
}
