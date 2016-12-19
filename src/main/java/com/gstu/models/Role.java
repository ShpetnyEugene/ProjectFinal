package com.gstu.models;


public enum Role {
    USER(1),ADMIN(2);

    private int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    public Role roleFromId(int roleId) {
        for(Role role: Role.values()) {
            if(role.roleId==roleId) {
                return role;
            }
        }
//throw new UnsupportedOperationException();

        throw new IllegalArgumentException();
    }
}
