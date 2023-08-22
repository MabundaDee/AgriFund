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
@Table(name = "crops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "porfolio_id")
    public Portfolio portfolio;

    @Column(name = "crop_name", nullable = false)
    @NotBlank(message = "Crop name is required.")
    private String cropName;

    @Column(name = "crop_type", nullable = false)
    @NotBlank(message = "Crop type is required.")
    private String cropType;

    @Column(name = "season", nullable = false)
    @NotBlank(message = "Season is required.")
    private String season;

    @Column(name = "crop_price", nullable = false)
    @NotNull(message = "Crop price is required.")
    @Min(value = 1, message = "Crop price must be greater than 0.")
    private Double cropPrice;

    @Column(name = "market_value", nullable = false)
    @NotNull(message = "Market value is required.")
    @Min(value = 1, message = "Market value must be greater than 0.")
    private Double marketValue;

}
