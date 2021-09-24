package com.shum.ships_tb.service.port;

import com.shum.ships_tb.repository.entity.RepoPort;

import java.util.List;

public interface IPort {
    List<RepoPort> findAll();
}
