package org.example.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CT_USER")
@Data
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private String password;
    private boolean verified;
    private boolean locked;

    @Column(name = "ACC_CRED_EXPIRED")
    private boolean accountCredentialsExpired;

}
