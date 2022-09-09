package com.example.backend.repository.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "application_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    private String username;

    @NotNull
    @Column(name = "password_hash")
    private String passwordHash;

    @NotNull
    private boolean enabled;

    @OneToMany(mappedBy = "manager")
    private Set<Client> clientSet;

    @CreationTimestamp
    @Column(insertable = false, updatable = false)
    private Timestamp created;

}
