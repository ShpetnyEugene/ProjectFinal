package com.gstu.controllers;

import com.gstu.utils.DateUtils;

public class Main {
    public static void main(String[] args) {
        DateUtils dateUtils = new DateUtils();
        System.out.println(dateUtils.changeFormatDate("04.01.2017"));
    }
}
