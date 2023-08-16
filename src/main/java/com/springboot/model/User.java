package com.springboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "User ID", example = "1", hidden = true)
    private Long id;

    @Column(name = "first_name",nullable = false, length = 50)
    @NotBlank(message = "first name is mandatory")
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 50)
    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @Column(name = "email", unique = true)
    @NotBlank(message = "email is mandatory")
    @Email(message = "email should be a valid email")
    private String email;

    @Column(name = "password")
    @Schema(description = "password", example = "123456", required = true)
    @NotBlank(message = "password is mandatory")
    private String password;

    @Column(name = "contact_number")
    @Schema(description = "contact number", example = "1234564498", required = true)
    @NotBlank(message = "contact number is mandatory")
    private String contactNumber;

}
