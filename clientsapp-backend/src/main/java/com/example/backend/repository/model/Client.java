package com.example.backend.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 64)
    private String username;

    @NotNull
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String address;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp changed;
}
