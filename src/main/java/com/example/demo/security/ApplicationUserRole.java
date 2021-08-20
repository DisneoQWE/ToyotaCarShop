package com.example.demo.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(ADMIN_READ_CLIENT_STORY, CLIENT_ORDER,
            CLIENT_WRITE, ADMIN_REPORT_CLIENT)),
    MANAGER(Sets.newHashSet(CLIENT_ORDER, CLIENT_WRITE)),
    CLIENT(Sets.newHashSet());
    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
