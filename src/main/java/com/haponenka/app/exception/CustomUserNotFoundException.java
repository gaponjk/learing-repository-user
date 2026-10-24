package com.haponenka.app.exception;

public class CustomUserNotFoundException extends RuntimeException {
  public CustomUserNotFoundException(String message) {
    super(message);
  }

  public CustomUserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomUserNotFoundException(Throwable cause) {
    super(cause);
  }

  public CustomUserNotFoundException() {}
}
