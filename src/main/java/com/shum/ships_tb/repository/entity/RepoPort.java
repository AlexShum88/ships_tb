package com.shum.ships_tb.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "ports")
public class RepoPort {
    @Id
    @Column (name= "id")
    private int id;
    @Column (name= "name")
    private String name;
    @Column (name= "description")
    private String description;
    @Column (name= "politic")
    private String politic;
    @Column (name= "cargo")
    private String cargo;
    @Column (name= "price_list")
    private String priceList;

}
