package com.example.flighttask.demo.dto;

import java.util.UUID;

// This data transfer object (DTO) describes how to JSON response should look 
// Typically this would extend from a generic response DTO to save code repetition
// if more different responses were required
public class ParseResponseDto {

  private Data data;

  public ParseResponseDto(int matchedOccurrences) {
    this.data = new Data(matchedOccurrences);
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public static class Data {

    private UUID id = UUID.randomUUID();
    private String type;
    private Attributes attributes;

    public Data(int matchedOccurrences) {
      this.type = "stringMatch";
      this.attributes = new Attributes(matchedOccurrences);
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public UUID getId() {
      return id;
    }

    public void setId(UUID id) {
      this.id = id;
    }

    public Attributes getAttributes() {
      return attributes;
    }

    public void setAttributes(Attributes attributes) {
      this.attributes = attributes;
    }
  }

  public static class Attributes {
    private int matchedOccurrences;

    public Attributes(int matchedOccurrences) {
      this.matchedOccurrences = matchedOccurrences;
    }

    public int getMatchedOccurrences() {
      return matchedOccurrences;
    }

    public void setMatchedOccurrences(int matchedOccurrences) {
      this.matchedOccurrences = matchedOccurrences;
    }
  }

}
