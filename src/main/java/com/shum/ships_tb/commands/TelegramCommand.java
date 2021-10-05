package com.shum.ships_tb.commands;

import com.shum.ships_tb.telegram.Messager;

public interface TelegramCommand {
     /**basic command intf*/
     void execute (String chatId);

}
