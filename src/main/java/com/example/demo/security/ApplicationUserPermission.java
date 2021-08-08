package com.example.demo.security;

public enum ApplicationUserPermission {
    CLIENT_READ("client: read"),
    CLIENT_WRITE("client: write"),
    ADMIN_READ("admin: read"),
    ADMIN_WRITE("admin: write");
    private final String permission;
    ApplicationUserPermission(String permission){
        this.permission = permission;
    }
}
