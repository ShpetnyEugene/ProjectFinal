package com.gstu.dao;
/**
 * @author Shpetny Eugene
 * @version 1.0
 * */

public class DataAccessException extends RuntimeException {

    public DataAccessException (String s) {
        super(s);
    }

    public DataAccessException(String s, Exception ex ) {
        super(s,ex);
    }

    public DataAccessException(Exception ex){
        super(ex);
    }
}
