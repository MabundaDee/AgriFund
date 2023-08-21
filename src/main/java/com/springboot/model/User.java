package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "User ID", example = "1", hidden = true)
    private Long id;

    @Column(name = "first_name",nullable = false, length = 50)
    @NotBlank(message = "first name is mandatory")
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 50)
    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 50)
    @NotBlank(message = "email is mandatory")
    @Email(message = "email should be a valid email")
    private String email;

    @Column(name = "password",nullable = false, length = 50)
    @NotBlank(message = "password is mandatory")
    private String password;

    @Column(name = "contact_number",nullable = false, length = 10)
    @NotBlank(message = "contact number is mandatory")
    private String contactNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)})
    @JsonIgnore
    private Set<UserRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Portfolio> portfolios = new HashSet<>();



}
