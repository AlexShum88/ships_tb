package com.shum.ships_tb.commands;

public interface SetTextInlineTelegramCommand extends TelegramCommand {
    String setTextAndExecute(String chatId, String text);
}
