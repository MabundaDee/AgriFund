package com.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "farmer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Farmer extends User{

    @Column(name = "id_number", nullable = false, length = 13)
    @NotBlank(message = "ID number is required")
    @Pattern(regexp = "^(((\\d{2}((0[13578]|1[02])(0[1-9]|[12]\\d|3[01])|(0[13456789]|1[012])(0[1-9]|[12]\\d|30)|02(0[1-9]|1\\d|2[0-8])))|([02468][048]|[13579][26])0229))(( |-)(\\d{4})( |-)(\\d{3})|(\\d{7}))$", message = "ID number is invalid (must be a valid South African ID number)")
    private String idNumber;
}
