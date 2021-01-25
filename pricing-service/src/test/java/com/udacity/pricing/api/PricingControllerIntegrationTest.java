package com.udacity.pricing.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.udacity.pricing.domain.price.Price;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PricingControllerIntegrationTest {
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;


  @Test
  void getSuccessResponseForValidVehicleID() {
    ResponseEntity<Price> responseEntity =
        this.testRestTemplate.getForEntity("http://localhost:"+port+"/services/price/?vehicleId=1",Price.class);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

  }

  @Test
  void getFailureResponseForInvalidVehicleId() {
    ResponseEntity<Price> responseEntity =
        this.testRestTemplate.getForEntity("http://localhost:"+port+"/services/price/?vehicleId=-1",Price.class);

    assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

  }
}