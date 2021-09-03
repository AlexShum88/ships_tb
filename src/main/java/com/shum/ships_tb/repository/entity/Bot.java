package com.shum.ships_tb.repository.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="bot")
public class Bot {
    @Id
    @Column(name="token")
    private String token;

    @Column (name="name")
    private String name;
}
