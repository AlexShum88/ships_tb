package com.shum.ships_tb.commands;

import com.shum.ships_tb.repository.entity.RepoShip;
import com.shum.ships_tb.service.ship.IShip;
import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

import java.util.ArrayList;
import java.util.List;

public class ViewMyShipITC extends InlineTelegramCommand{

    private final IShip iShip;
    public ViewMyShipITC(KeyboardDirector keyboardDirector, Messager messager, IShip iShip) {
        super(keyboardDirector, messager);
        this.iShip = iShip;
    }

    @Override
    public void execute(String chatId) {
        var kb = keyboardDirector.productor(myShips(chatId));
        messager.sentMessage(chatId, "here you ships", kb);
    }

    private List<String> myShips (String chatId) {
        List<String> ships = new ArrayList<>();
        for (RepoShip rsh: iShip.findByOwner(chatId)){
            ships.add(rsh.getName());
        }
        return ships;
    }
}
