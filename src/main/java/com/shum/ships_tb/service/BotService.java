package com.shum.ships_tb.service;

import com.shum.ships_tb.repository.entity.Bot;


import java.util.List;

public interface BotService {
    List<Bot> findByName();
}
