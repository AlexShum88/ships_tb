package com.shum.ships_tb.service;

import com.shum.ships_tb.repository.BotRepository;
import com.shum.ships_tb.repository.entity.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * end implementation of adding from db bot token and name
 */
@Service
public class BotServiceImpl implements BotService {
    private final BotRepository botRepository;

    @Autowired
    public BotServiceImpl(BotRepository botRepository) {
        this.botRepository = botRepository;
    }


    @Override
    public List<Bot> findByName() {
        return botRepository.findByNameNotNull();
    }


}
