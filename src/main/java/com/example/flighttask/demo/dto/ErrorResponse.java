package com.example.flighttask.demo.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

  private Error error;

  public ErrorResponse(HttpStatus status, String detail) {
    this.error = new Error(status.toString(), detail);
  }

  public Error getErrors() {
    return error;
  }

  public static class Error {

    private String status;
    private String detail;

    public Error(String status, String detail) {
      this.status = status;
      this.detail = detail;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public String getDetail() {
      return detail;
    }

    public void setDetail(String detail) {
      this.detail = detail;
    }

  }

}
