package com.ise.broker.sql.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "portfolio")

public class Portfolio {

    @Id
    private Long portfolioID;

    @JsonManagedReference
    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "accountID")
    private Account account;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "net_worth", nullable = false)
    private Double net_worth;

    @JsonManagedReference
    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "asset_portfolio",
        joinColumns = @JoinColumn(name = "portfolio_id"),
        inverseJoinColumns = @JoinColumn(name = "asset_id")
    )
    private Set<Asset> assets = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(portfolioID, portfolio.portfolioID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portfolioID);
    }

}