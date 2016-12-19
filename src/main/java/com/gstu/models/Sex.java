package com.gstu.models;


public enum  Sex {
    MALE(1),FEMALE(2);

    private int sexId;

    Sex(int sexId) {
        this.sexId = sexId;
    }

    public Sex sexFromId(int sexId) {
        for(Sex sex: Sex.values()) {
            if(sex.sexId==sexId) {
                return sex;
            }
        }

        // TODO ВНЕСТИ
//throw new UnsupportedOperationException();

        throw new IllegalArgumentException();
    }


}
