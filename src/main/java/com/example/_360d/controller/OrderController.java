package com.example._360d.controller;

import com.example._360d.model.OrderRequest;
import com.example._360d.model.OrderRequestResponse;
import com.example._360d.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example._360d.model.OrderRequestResponse.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;


    @Operation(description = "The endpoint used to register an order from a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400")
    })
    @PostMapping(
            value = "v1/orders",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    OrderRequestResponse requestOrder(@Valid @RequestBody OrderRequest order) {

        //TODO
        // ADD integration with NBP and cache
        // email notification

        log.info("Requested the order: {}", order);

        RegistrationStatus status = service.registerOrder(order);

        return new OrderRequestResponse(status);
    }
}
