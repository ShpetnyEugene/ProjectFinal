package com.gstu.models;

/**
 * @author Shpetny Eugene
 * @version 1.0
 * */

public class Bid {

    private long id;
    private int price;

    public Bid() {
    }

    public Bid(long id, int price) {
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (id != bid.id) return false;
        if (price != bid.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}

