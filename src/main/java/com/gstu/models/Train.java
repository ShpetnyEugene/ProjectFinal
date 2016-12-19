package com.gstu.models;

/**
 * @author Shpetny Eugene
 * @version 1.0
 * */

public class Train {

    // TODO конструктор изменить а также getters and setters
    private long idTrain;
    private String name;
    private int numberFreePlaces;

    public Train() {
    }

    //TODO TOSTRING изменить

    public Train(long idTrain, String name,int numberFreePlaces) {
        this.idTrain = idTrain;
        this.name = name;
        this.numberFreePlaces = numberFreePlaces;
    }

    public long getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(long idTrain) {
        this.idTrain = idTrain;
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

        if (idTrain != train.idTrain) return false;
        return name != null ? name.equals(train.name) : train.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (idTrain ^ (idTrain >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Train{" +
                "idTrain=" + idTrain +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNumberFreePlaces() {
        return numberFreePlaces;
    }

    public void setNumberFreePlaces(int numberFreePlaces) {
        this.numberFreePlaces = numberFreePlaces;
    }
}