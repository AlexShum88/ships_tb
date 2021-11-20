package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public class StartITC extends InlineTelegramCommand implements SetTextInlineTelegramCommand{
    public StartITC(KeyboardDirector keyboardDirector, Messager messager) {
        super(keyboardDirector, messager);

    }

    @Override
    public void execute(String chatId) {
        var kb = keyboardDirector.productor("/create_new_ship","/show_my_ships");
        messager.sentMessage(chatId, "hello", kb);//todo there info about player
    }

    @Override
    public String setTextAndExecute(String chatId, String text) {
        execute(chatId);
        return text;
    }
}
