package com.shum.ships_tb.service.cargo;

import com.shum.ships_tb.repository.entity.RepoCargo;

import java.util.List;

public interface ICargo {
    List<RepoCargo> findAll();
}
