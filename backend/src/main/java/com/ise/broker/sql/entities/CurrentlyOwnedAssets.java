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
    @Column(name = "currentlyOwnedAssetID", insertable = false, updatable = false, nullable = false, unique = true)
    private Long currentlyOwnedAssetID;

    @Column(name = "no_of_shares", nullable = false)
    private Integer no_of_shares;

    @Column(name = "avg_price", nullable = false)
    private Double avg_price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "assetID", nullable = false)
    private Asset asset;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "accountID", nullable = false)
    private Account account;

    


    
}
