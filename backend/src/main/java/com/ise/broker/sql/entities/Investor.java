package com.ise.broker.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Investor {
    @Id
    private Long id;
}
