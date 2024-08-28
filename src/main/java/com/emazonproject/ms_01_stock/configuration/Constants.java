package com.emazonproject.ms_01_stock.configuration;

public class Constants {
    private Constants(){throw new IllegalStateException("Utility class");}


    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No se encontraron datos en la base de datos";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "El elemento indicado no existe";
    public static final String CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "La categoría que quieres crear ya existe";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "el campo %s no puede estar vacio";
    public static final String NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE = "el campo %s no recibe valores negativos";



}
