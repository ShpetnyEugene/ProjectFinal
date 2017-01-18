package com.gstu.controllers;


public class Main {
    public static void main(String[] args) {
        String a = "ds";
        long f = 0;
        try {
             f = Long.parseLong(a);

        }catch (Exception e){
            f = 0;
            System.out.println("ERROR");
        }
        System.out.println(f);

    }
}
