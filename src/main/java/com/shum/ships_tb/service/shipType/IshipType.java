package com.shum.ships_tb.service.shipType;

import com.shum.ships_tb.repository.entity.RepoShipType;

import java.util.List;

public interface IshipType {

    List<RepoShipType> findAll();
    RepoShipType findByName(String name);
}
