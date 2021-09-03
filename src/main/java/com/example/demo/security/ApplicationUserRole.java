package com.example.demo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

     public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
//      Todo: Получше изучить и потренить Java Stream api, чтобы как курица в новозе не копаться
// Пояснение для себя: Создается объект permission списка из SimpleGrantedAuthority
// получаем пермишион, создаем стрим и изменяем каждый пермишон = new SimpleGrantedAuthority
//и после (collect) возвращаем результат в виде списка
        Set<SimpleGrantedAuthority> permission = getPermissions().stream()
                .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
        return permission;
    }
}
