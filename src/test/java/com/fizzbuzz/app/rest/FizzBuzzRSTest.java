package com.fizzbuzz.app.rest;

import com.fizzbuzz.app.model.FizzBuzzResponse;
import com.fizzbuzz.app.service.FizzBuzzService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;

/**
 * @author vanithadevig
 */
@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzRSTest {

    @Mock
    FizzBuzzService fizzBuzzService;

    @InjectMocks
    FizzBuzzRS fizzBuzzRS;

    @Test
    public void testGetFizzBuzzWithValidInput() throws IOException{

        List<Integer> buzzs = Lists.newArrayList(5,10,15);
        List<Integer> fizzs = Lists.newArrayList(3,6,9,12,15);
        List<Integer> fizzBuzzs = Lists.newArrayList(15);

        FizzBuzzResponse mockFizzBuzzResponse = new FizzBuzzResponse();
        mockFizzBuzzResponse.setBuzzs(buzzs);
        mockFizzBuzzResponse.setFizzs(fizzs);
        mockFizzBuzzResponse.setFizzbuzzs(fizzBuzzs);

        when(fizzBuzzService.calculateFizzBuzz(15)).thenReturn(mockFizzBuzzResponse);

        Response response = fizzBuzzRS.getFizzBuzz(15);
        FizzBuzzResponse fizzBuzzResponses = (FizzBuzzResponse) response.getEntity();
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
        assertEquals(fizzBuzzResponses.getBuzzs().size(),3);
        assertTrue(fizzBuzzResponses.getBuzzs().containsAll(buzzs));
        assertEquals(fizzBuzzResponses.getFizzs().size(),5);
        assertTrue(fizzBuzzResponses.getFizzs().containsAll(fizzs));
        assertEquals(fizzBuzzResponses.getFizzbuzzs().size(),1);
        assertTrue(fizzBuzzResponses.getFizzbuzzs().containsAll(fizzBuzzs));
    }


    @Test
    public void testGetFizzBuzzBoundaryConditionWhenMaxValueIsZero() throws IOException {

        Response response = fizzBuzzRS.getFizzBuzz(0);

        assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
        assertNull(response.getEntity());
    }

    @Test
    public void testGetFizzBuzzBoundaryConditionWhenMaxValueIsLesserThanZero() throws IOException {

        Response response = fizzBuzzRS.getFizzBuzz(-15);

        assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
        assertNull(response.getEntity());
    }

}
