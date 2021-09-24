package com.shum.ships_tb.repository;

import com.shum.ships_tb.repository.entity.RepoPort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PortRepository extends CrudRepository<RepoPort, Long> {
    List<RepoPort> findAll();
}
