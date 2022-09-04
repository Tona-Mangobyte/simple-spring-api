package com.mb.article.common;

public enum UserRole {
    ADMIN_ROLE("ADMIN_ROLE"),
    USER_ROLE("USER_ROLE");

    private final String role;
    private UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
