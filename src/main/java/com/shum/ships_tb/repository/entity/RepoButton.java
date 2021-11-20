package com.shum.ships_tb.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name ="buttons")
public class RepoButton {
    @Id
    @Column (name = "command")
    private String command;

    @Column (name="en")
    private String en;

    @Column (name="ru")
    private String ru;
}
