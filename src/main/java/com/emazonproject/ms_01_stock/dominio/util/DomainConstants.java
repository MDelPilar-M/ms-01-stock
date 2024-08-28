package com.emazonproject.ms_01_stock.dominio.util;

public class DomainConstants {
    private DomainConstants(){ throw new IllegalStateException("Utility class");}

    public enum Field{
        NAME,
        DESCRIPTION
    // campos que se usan
    }
    public static final Integer DATA_SIZE_LIMIT_NAME = 50;
    public static final Integer DATA_SIZE_LIMIT_DESCRIPTION = 90;
    public static final String DATA_SIZE_LIMIT_NAME_MESSAGE = "Campo 'name' excede el limite de longitud";
    public static final String DATA_SIZE_LIMIT_DESCRIPTION_MESSAGE = "Campo 'description' excede el limite de longitud ";
}
