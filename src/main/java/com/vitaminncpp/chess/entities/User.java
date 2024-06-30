package com.vitaminncpp.chess.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "id")})
public class User implements UserDetails {
    @Id
    @Column(name = "id", nullable = false, unique = true, table = "users")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true, table = "users")
    private String username;

    @Column(name = "name", nullable = false, table = "users")
    private String name;

    @Column(name = "email", nullable = false, unique = true, table = "users")
    private String email;

    @Column(name = "password", nullable = false, table = "users")
    private String password;

    @Column(name = "is_deleted", nullable = false, table = "users")
    private boolean isDeleted = false;

    @Column(name = "is_disabled", nullable = false, table = "users")
    private boolean isDisabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isDeleted;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isDisabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isDisabled;
    }

    @Override
    public boolean isEnabled() {
        return !this.isDisabled;
    }
}
