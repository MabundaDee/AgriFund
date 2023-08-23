package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "plot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "porfolio_id")
    private Portfolio portfolio;

    @Column(name = "asset_name", nullable = false)
    @NotBlank(message = "Asset name is required.")
    private String assetName;

    @Column(name = "asset_type", nullable = false)
    @NotBlank(message = "asset type required")
    private String assetType;

    @Column(name ="age", nullable = false)
    @NotNull(message = "asset age is required")
    @Min(value = 1,message = "asset age should be greater 0.")
    private Integer age;

    @Column(name = "purchase_price",nullable = false)
    @NotNull(message = "the purchase price is required")
    @Min(value = 1,message = "purchase price must be greater than 0.")
    private Double purchasePrice;
}
