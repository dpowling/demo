package com.example.flighttask.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flighttask.demo.dto.ErrorResponse;
import com.example.flighttask.demo.dto.ParseResponseDto;
import com.example.flighttask.demo.service.ParseService;

@RestController
@RequestMapping("/api/parse")
public class ParseController {

  @Autowired
  private ParseService parseService;

  @GetMapping
  public ResponseEntity<ParseResponseDto> getParsedString(@RequestParam String inString) {

    ParseResponseDto responseDto = new ParseResponseDto(parseService.parseString(inString));

    return new ResponseEntity<ParseResponseDto>(responseDto, HttpStatus.OK);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<ErrorResponse> handleMissingQueryParam(MissingServletRequestParameterException ex) {

    String parameterName = ex.getParameterName();

    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,
        "Missing required query parameter: " + parameterName);

    return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
  }

}
