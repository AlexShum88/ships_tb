package com.shum.ships_tb.repository;

import com.shum.ships_tb.repository.entity.RepoButton;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ButtonsRepository extends JpaRepository<RepoButton, Long> {
    RepoButton findBycommand(String command);
    List<RepoButton> findAll ();
}
