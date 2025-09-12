package org.nttdata.com.servicioprestamos.exception;

public class BadRequest extends RuntimeException {
  public BadRequest(String message) {
    super(message);
  }
}
