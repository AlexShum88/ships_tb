package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public class CreateNewShipITC extends InlineTelegramCommand{
    public CreateNewShipITC(KeyboardDirector keyboardDirector, Messager messager) {
        super(keyboardDirector, messager);
    }

    @Override
    public void execute(String chatId) {
        var kb = keyboardDirector.productor("/enter_ship_name", "/set_ship_class");
        messager.sentMessage(chatId, "hello", kb);
    }
}
