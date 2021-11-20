package com.shum.ships_tb.repository;

import com.shum.ships_tb.repository.entity.RepoShipType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipTypeRepository extends JpaRepository<RepoShipType, Long> {

    List<RepoShipType> findAll ();
}
