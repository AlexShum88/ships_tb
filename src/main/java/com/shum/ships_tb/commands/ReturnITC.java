package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public class ReturnITC extends InlineTelegramCommand{
    public ReturnITC(KeyboardDirector keyboardDirector, Messager messager) {
        super(keyboardDirector, messager);
    }

    @Override
    public void execute(String chatId) {

    }
}
