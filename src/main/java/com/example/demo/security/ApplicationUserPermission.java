package com.example.demo.security;

public enum ApplicationUserPermission {
    CLIENT_ORDER("client: order"),
    CLIENT_WRITE("client: write"),
    ADMIN_READ_CLIENT_STORY("admin: read client story"),
    ADMIN_REPORT_CLIENT("admin: report client");
    private final String permission;
    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
