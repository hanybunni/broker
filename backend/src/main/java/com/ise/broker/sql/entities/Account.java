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
@Table(name = "accounts")

public class Account {

    @Id
    @Column(name = "accountID", insertable = false, updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "currency", nullable = false)
    private String currency;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "investorID", nullable = false)
    private Investor investor;

    @JsonManagedReference
    @ManyToMany(mappedBy = "accounts")
    private Set<Watchlist> watchlists = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CurrentlyOwnedAssets> currentlyOwnedAssets;

    @JsonManagedReference
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<>();

}