package com.ise.broker.sql.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Investor")

public class Investor {

	@Id
    @Column(name = "investorID", updatable = false, nullable = false, unique = true)
    private String investorID;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "citizenship", nullable = false)
    private String citizenship;
    
}