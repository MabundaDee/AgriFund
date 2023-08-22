package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "plot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "portfolio_id")
    public Portfolio portfolio;

    @Column(name = "plot_address", nullable = false)
    @NotBlank(message = "Plot address is required.")
    private String plotAddress;

    @Column(name = "plot_size", nullable = false)
    @NotNull(message = "Plot size is required.")
    private Double plotSize;

    @Column(name = "proof_of_ownership", nullable = false)
    @NotBlank(message = "proof of ownership is required")
    private String proofOfOwnership;

}
