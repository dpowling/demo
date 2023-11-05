package com.example.flighttask.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ParseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testParseEndpoint() throws Exception {
    String queryParam = "sdflocgzhmtiq94)tzplsfmnixg7h";

    mockMvc.perform(MockMvcRequestBuilders.get("/api/parse").param("inString", queryParam))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.attributes.matchedOccurrences").value(2));
  }

}
