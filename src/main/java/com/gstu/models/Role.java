package com.gstu.models;


public enum Role {
    USER(2),ADMIN(1);

    private int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    public static Role roleFromId(Integer roleId) {
        for(Role role: Role.values()) {
            if(role.roleId==roleId) {
                return role;
            }
        }
        throw new IllegalArgumentException();
    }


}
