package com.ise.broker.sql.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "currently_owned_assets")

public class CurrentlyOwnedAssets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column(name = "no_of_shares", nullable = false)
    private Integer no_of_shares;

    @Column(name = "avg_price", nullable = false)
    private Double avg_price;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "assetID", nullable = false)
    private Asset asset;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "accountID", nullable = false)
    private Account account;

    


    
}
