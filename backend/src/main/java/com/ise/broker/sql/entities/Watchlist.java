package com.ise.broker.sql.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "watchlists")

public class Watchlist {

    @Id
    @Column(name = "watchlistID", updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long watchlistID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "visibility", nullable = false)
    private String visibility;

    @JsonManagedReference
    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "account_watchlist",
        joinColumns = @JoinColumn(name = "watchlist_id"),
        inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private Set<Account> accounts = new HashSet<>();
    
    @JsonManagedReference
    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "asset_watchlist",
        joinColumns = @JoinColumn(name = "watchlist_id"),
        inverseJoinColumns = @JoinColumn(name = "asset_id")
    )
    private Set<Asset> assets;


    
}
