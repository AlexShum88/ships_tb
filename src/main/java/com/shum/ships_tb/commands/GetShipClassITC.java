package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public class GetShipClassITC extends InlineTelegramCommand implements SetTextInlineTelegramCommand{

    public GetShipClassITC(KeyboardDirector keyboardDirector, Messager messager) {
        super(keyboardDirector, messager);
    }

    @Override
    public void execute(String chatId) {

    }

    @Override
    public String setTextAndExecute(String chatId, String text) {
        var kb = keyboardDirector.productor("/return");
        messager.sentMessage(chatId, text, kb);
        getShipPressetByName(text);
        return text;
    }

    private void getShipPressetByName(String pressetName){}

    //todo realise game logic of create new ship
}
