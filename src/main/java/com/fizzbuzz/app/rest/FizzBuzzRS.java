package com.fizzbuzz.app.rest;

import com.fizzbuzz.app.model.FizzBuzzResponse;
import com.fizzbuzz.app.service.FizzBuzzService;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * {@link  FizzBuzzRS} is the Rest Service to address all endpoints related to FizzBuzz service
 *
 * @author vanithadevig
 *
 */

@Path("/fizzbuzz")
@Api("Fizz Buzz Endpoints")
public class FizzBuzzRS {

    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzRS.class);

    @Inject
    FizzBuzzService fizzBuzzService;

    /**
     * <code>getFizzBuzz</code> calls the {@link  FizzBuzzService} to determine the list of Fizz, Buzz
     * and FizzBuzz numbers.
     *
     * @param maxValue - max value for the {@link  FizzBuzzService}
     *
     * @return list of objects that contains list of Fizz, Buzz, FizzBuzz numbers for valid input
     *
     */
    @GET
    @Path("/{maxValue}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "FizzBuzz Api", response = FizzBuzzResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = FizzBuzzResponse.class),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public Response getFizzBuzz(@ApiParam(value = "Max Value") final @PathParam("maxValue") int maxValue) {

        LOGGER.info("getFizzBuzz- maxValue: {} ", maxValue);

        // to return all negative and zero values as invalid
        if (maxValue <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(fizzBuzzService.calculateFizzBuzz(maxValue)).build();
    }
}
