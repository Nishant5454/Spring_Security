package com.example.Security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="authorities")
public class Authorities {
    @Id
    private String username;
    private String Authority;
    public Authorities(String username,String Authority) {
        this.username = username;
        this.Authority = Authority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }

    public String getAuthority() {
        return Authority;
    }
}
