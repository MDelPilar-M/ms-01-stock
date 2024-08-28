package com.EmazonProject.ms_01_stock.dominio.exception;

public class IlegalArgumentException extends RuntimeException {
  public IlegalArgumentException(String message) {
    super(message);
  }
}
