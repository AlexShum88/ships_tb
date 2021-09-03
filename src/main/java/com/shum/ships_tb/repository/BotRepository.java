package com.shum.ships_tb.repository;

import com.shum.ships_tb.repository.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *realisation jpaRepository to get bot name and token from db.
 */

@Repository
public interface BotRepository extends JpaRepository<Bot, String> {

    List<Bot> findByNameNotNull();
}
