package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public class GetNameITC extends InlineTelegramCommand implements SetTextInlineTelegramCommand{
    public GetNameITC(KeyboardDirector keyboardDirector, Messager messager) {
        super(keyboardDirector, messager);
    }

    @Override
    public void execute(String chatId) {

    }

    @Override
    public String setTextAndExecute(String chatId, String text) {
        //todo add name to users db
        var kb = keyboardDirector.productor("/new_ship", "/show_my_ships");
        messager.sentMessage(chatId, String.format("hello, %s", text), kb);
        return text;
    }
}
