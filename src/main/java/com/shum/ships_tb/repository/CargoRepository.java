package com.shum.ships_tb.repository;

import com.shum.ships_tb.repository.entity.RepoCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<RepoCargo, String> {
    List<RepoCargo> findAll ();
}
