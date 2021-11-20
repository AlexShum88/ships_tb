package com.shum.ships_tb.service.button;

import com.shum.ships_tb.repository.ButtonsRepository;
import com.shum.ships_tb.repository.entity.RepoButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ButtonImpl  implements Ibutton{

    private final ButtonsRepository buttonsRepository;

    @Autowired
    public ButtonImpl(ButtonsRepository buttonsRepository) {
        this.buttonsRepository = buttonsRepository;
    }

    @Override
    public RepoButton findByCommand(String command) {
        return buttonsRepository.findBycommand(command);
    }

    @Override
    public List<RepoButton> findAll() {
        return buttonsRepository.findAll();
    }
}
