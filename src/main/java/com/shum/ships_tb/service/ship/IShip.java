package com.shum.ships_tb.service.ship;

import com.shum.ships_tb.gameObj.Ship;
import com.shum.ships_tb.repository.entity.RepoShip;

import java.util.List;

public interface IShip {

    List<RepoShip> findByOwner(String owner);

    RepoShip findById(Integer id, List<RepoShip> rp);

    void save (Ship ship);

    RepoShip findByNameInOwner(String shName, String owner);
}
