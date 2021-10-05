package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public abstract class InlineTelegramCommand implements TelegramCommand{

    protected KeyboardDirector keyboardDirector;
    protected Messager messager;

    public InlineTelegramCommand(KeyboardDirector keyboardDirector, Messager messager) {
        this.keyboardDirector = keyboardDirector;
        this.messager = messager;
    }


}
