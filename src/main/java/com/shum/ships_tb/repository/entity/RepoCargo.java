package com.shum.ships_tb.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cargo")
public class RepoCargo {

    @Id
    @Column (name ="name")
    private String name;

    @Column(name="weight")
    private int weight;

}
