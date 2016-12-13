package com.gstu.models;

/**
 * @author Shpetny Eugene
 * @version 1.0
 * */

public class Train {

    // TODO конструктор изменить а также getters and setters
    private long id;
    private String name;
    private int numberFreePlaces;

    public Train() {
    }

    //TODO TOSTRING изменить

    public Train(long id, String name,int numberFreePlaces) {
        this.id = id;
        this.name = name;
        this.numberFreePlaces = numberFreePlaces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (id != train.id) return false;
        return name != null ? name.equals(train.name) : train.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}