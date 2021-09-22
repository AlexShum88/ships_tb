package com.shum.ships_tb.repository;

import com.shum.ships_tb.repository.entity.RepoShip;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ShipRepository extends CrudRepository<RepoShip, Long> {

    List<RepoShip> findByowner(String owner);
}
