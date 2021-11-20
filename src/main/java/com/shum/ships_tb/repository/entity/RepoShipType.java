package com.shum.ships_tb.repository.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "ship_types")
public class RepoShipType {

    @Id
    @Column (name = "presset_name")
    private String pressetName;

    @Column(name="hull")
    private int hull;

    @Column(name="maxfuel")
    private int maxFuel;

    @Column(name="movementspeed")
    private int movementSpeed;

    @Column(name="cargocapacity")
    private int cargoCapacity;
}
