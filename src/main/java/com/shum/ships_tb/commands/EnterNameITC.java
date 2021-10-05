package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.CommandListener;
import com.shum.ships_tb.telegram.KeyboardDirector;
import com.shum.ships_tb.telegram.Messager;

public class EnterNameITC extends InlineTelegramCommand {

    private final CommandListener commandListener;

    public EnterNameITC(KeyboardDirector keyboardDirector, Messager messager, CommandListener commandListener) {
        super(keyboardDirector, messager);
        this.commandListener = commandListener;
    }

    @Override
    public void execute(String chatId) {
        commandListener.setMessageListener(chatId, "/get_name");
        messager.sentMessage(chatId, "enter you name, pls");
    }


}
