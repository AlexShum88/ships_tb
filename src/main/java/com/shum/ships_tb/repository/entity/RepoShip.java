package com.shum.ships_tb.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "ship")
public class RepoShip {
    @Column(name="name")
    private String name;
    @Column(name="owner")
    private String owner; //todo in db need to make users table and set foreign key to this column
    @Id
    @Column(name="id")
    private int id;
    @Column(name="movementspeed")
    private int movementSpeed;
    @Column(name="cargocapacity")
    private int cargoCapacity;
    @Column(name="fuel")
    private int fuel;
    @Column(name="maxfuel")
    private int maxFuel;
    @Column(name="hull")
    private int hull;
    @Column(name="captainskill")
    private int captainSkill;
    @Column(name="cargo_map")
    private String cargo_map; //this will have json string were cargo_name:cargo_quantity


    //todo need to add components[] than its ready

}
