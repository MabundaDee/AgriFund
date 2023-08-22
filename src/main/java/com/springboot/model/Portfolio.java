package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.org.glassfish.gmbal.ManagedAttribute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "portfolio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    public User user;

    @Column(name = "number of employee", nullable = false)
    @NotNull(message = "Number of employees is required.")
    @Min(value = 1, message = "Number of employees must be greater than 0.")
    private Integer numberOfEmployee;

    @Column(name = "farm name", nullable = false)
    @NotBlank(message = "Farm name is required.")
    private String farmName;

    @Column(name = "farm address", nullable = false)
    @NotBlank(message = "Farm address is required.")
    private String farmAddress;

    @Column(name = "years active", nullable = false)
    @NotNull(message = "Years active is required.")
    @Min(value = 1, message = "Years active must be greater than 0.")
    private Integer yearsActive;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Residential address is required")
    private String address;

    @Column(name = "reason for farming", nullable = false)
    @NotBlank(message = "Reason for farming is required")
    private String reasonForFarming;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Crops> crops;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
     private Set<Plot> plots;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Asset> assets ;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<IncomeStatement> incomeStatements;


}
