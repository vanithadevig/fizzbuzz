package com.fizzbuzz.app.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fizzbuzz.app.model.FizzBuzzResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * @author vanithadevig
 */
public class FizzBuzzRSIT {

    private static final String BASE_URI = "http://localhost:8889/fizzbuzz";


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetFizzBuzz() throws Exception {

        URI uri = UriBuilder.fromUri(BASE_URI).path("/{maxValue}")
                .build(15);
        FizzBuzzResponse response = get(uri, FizzBuzzResponse.class);

        assertEquals(1, response.getFizzbuzzs().size());
    }

    @Test
    public void testGetFizzBuzzWithString() throws IOException {

        try {
            URI uri = UriBuilder.fromUri(BASE_URI).path("/{maxValue}")
                    .build("gta");
            get(uri, FizzBuzzResponse.class);
        } catch (Exception e) {
            assertEquals(e.getMessage(), Response.Status.NOT_FOUND.getReasonPhrase());
        }
    }

    @Test
    public void testGetFizzBuzzWithNegativeNumbers() throws IOException {

        try {
            URI uri = UriBuilder.fromUri(BASE_URI).path("/{maxValue}")
                    .build(-123);
            get(uri, FizzBuzzResponse.class);
        } catch (Exception e) {
            assertEquals(e.getMessage(), Response.Status.BAD_REQUEST.getReasonPhrase());
        }
    }

    @Test
    public void testGetFizzBuzzWithZero() throws IOException {

        try {
            URI uri = UriBuilder.fromUri(BASE_URI).path("/{maxValue}")
                    .build(0);
            get(uri, FizzBuzzResponse.class);
        } catch (Exception e) {
            assertEquals(e.getMessage(), Response.Status.BAD_REQUEST.getReasonPhrase());
        }
    }

    private <T> T get(URI uri, Class<T> responseType) throws Exception {

        HttpGet httpGet = new HttpGet(uri);
        return httpExecute(httpGet, responseType);

    }

    private <T> T httpExecute(HttpRequestBase request, Class<T> responseType) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(request);

        if (response.getStatusLine().getStatusCode() != 200) {

            throw new Exception(response.getStatusLine().getReasonPhrase());

        }
        return objectMapper.readValue(response.getEntity().getContent(), responseType);
    }

}
