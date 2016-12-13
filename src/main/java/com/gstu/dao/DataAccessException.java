package com.gstu.dao;

public class DataAccessException extends RuntimeException {

    public DataAccessException (String s) {
        super(s);
    }

    public DataAccessException(String s, Exception ex ) {
        super(s,ex);
    }

}
