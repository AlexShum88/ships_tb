package com.shum.ships_tb.commands;

import com.shum.ships_tb.repository.entity.RepoShip;
import com.shum.ships_tb.repository.entity.RepoShipType;
import com.shum.ships_tb.service.shipType.IshipType;
import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

import java.util.ArrayList;
import java.util.List;

public class CreateNewShipITC extends InlineTelegramCommand{
    private final IshipType ishipType;
    public CreateNewShipITC(KeyboardDirector keyboardDirector, Messager messager, IshipType ishipType) {
        super(keyboardDirector, messager);
        this.ishipType = ishipType;
    }

    @Override
    public void execute(String chatId) {
        var kb = keyboardDirector.productor(ShipsPresetsName());
        messager.sentMessage(chatId, "Choose ship type", kb);
    }

    private List<String> ShipsPresetsName () {
        List<String> ships = new ArrayList<>();
        for (RepoShipType rsh: ishipType.findAll()){
            ships.add(rsh.getPressetName());
        }
        return ships;
    }
}
