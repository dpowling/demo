package com.example.flighttask.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ParseServiceTest {

  @InjectMocks
  private ParseService parseService;

  @Test
  public void testParseService() {

    String testString = "ausidhfoghtllsff";
    int result = parseService.parseString(testString);

    assertEquals(1, result);

  }

}
