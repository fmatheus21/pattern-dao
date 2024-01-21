package com.fmatheus.app.model.entity;

import com.fmatheus.app.controlle.constant.NamedQueryConstant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = NamedQueryConstant.USER_FIND_ALL, query = "SELECT u FROM User u")
@NamedQuery(name = NamedQueryConstant.USER_BY_USERNAME, query = "SELECT u FROM User u WHERE u.username = :username")
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_person"}),
        @UniqueConstraint(columnNames = {"id"}),
        @UniqueConstraint(columnNames = {"username"})})
public class User extends Base {

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 70)
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ToString.Exclude
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base base)) return false;
        return Objects.equals(getId(), base.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
