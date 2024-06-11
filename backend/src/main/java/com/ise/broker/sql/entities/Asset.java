package com.ise.broker.sql.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assets")

public class Asset {

    @Id
    @Column(name = "assetID", insertable = false, updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investorID;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @JsonManagedReference
    @ManyToMany(mappedBy = "assets")
    private Set<Watchlist> watchlists = new HashSet<>();

    @JsonManagedReference
    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "assets_of_asset", joinColumns = { @JoinColumn(name = "parent_assetID") }, inverseJoinColumns = {
            @JoinColumn(name = "child_assetID") })
    private Set<Asset> assets;

    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "curentlyOwnedAssetID", nullable = false)
    private Set<CurrentlyOwnedAssets> currentlyOwnedAssets;

    @JsonManagedReference
    @JsonBackReference
    @ManyToMany(mappedBy = "assets")
    private Set<Portfolio> portfolios = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<>();

}
