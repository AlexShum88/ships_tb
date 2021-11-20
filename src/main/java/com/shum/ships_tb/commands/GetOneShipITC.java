package com.shum.ships_tb.commands;

import com.shum.ships_tb.gameObj.Ship;
import com.shum.ships_tb.service.ship.IShip;
import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public class GetOneShipITC extends InlineTelegramCommand implements SetTextInlineTelegramCommand{
    private final IShip iShip;

    public GetOneShipITC(KeyboardDirector keyboardDirector, Messager messager, IShip iShip) {
        super(keyboardDirector, messager);
        this.iShip = iShip;
    }

    @Override
    public void execute(String chatId) {

    }

    private String showShip(String chatId, String shName){
        return new Ship(iShip.findByNameInOwner(shName, chatId)).toString();
    }

    @Override
    public String setTextAndExecute(String chatId, String text) {
        var kb = keyboardDirector.productor("/set_destination_point", "/load_cargo",
                "/unload_cargo", "/refuel", "/show_location_parameters");
        messager.sentMessage(chatId, showShip(chatId, text), kb);
        return text;
    }
}
