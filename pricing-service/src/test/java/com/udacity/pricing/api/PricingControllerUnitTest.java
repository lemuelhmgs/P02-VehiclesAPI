package com.udacity.pricing.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.udacity.pricing.service.PricingService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
class PricingControllerUnitTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  PricingService pricingService;

  @Test


  void getPriceForValidVehicle() throws Exception{
    mockMvc.perform(get("/services/price/?vehicleId=1"))

        .andExpect(status().isOk())
        .andExpect(content().contentType((MediaType.APPLICATION_JSON)))
        .andExpect((content().json("{}")));


  }
}