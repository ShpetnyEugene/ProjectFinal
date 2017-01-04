package com.gstu.models;

public class Station {

    private long idStation;
    private String name;
    private String name_ru;

    public Station() {
    }

    public Station(long idStation, String name, String name_ru) {
        this.idStation = idStation;
        this.name = name;
        this.name_ru = name_ru;
    }

    public long getIdStation() {
        return idStation;
    }

    public void setIdStation(long idStation) {
        this.idStation = idStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (idStation != station.idStation) return false;
        if (name != null ? !name.equals(station.name) : station.name != null) return false;
        return name_ru != null ? name_ru.equals(station.name_ru) : station.name_ru == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (idStation ^ (idStation >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (name_ru != null ? name_ru.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Station{" +
                "idStation=" + idStation +
                ", name='" + name + '\'' +
                ", name_ru='" + name_ru + '\'' +
                '}';
    }
}