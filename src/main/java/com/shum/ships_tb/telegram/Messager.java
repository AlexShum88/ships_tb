package com.shum.ships_tb.telegram;

import com.shum.ships_tb.ShipsBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Messager {

    ShipsBot shipsBot;
    /** need shipBot class there for sanding message (cant add execute method )*/
    public Messager(ShipsBot shipsBot) {
        this.shipsBot = shipsBot;
    }


    public void sentMessage (String chatId, String text, InlineKeyboardMarkup keyboard){
        SendMessage sm = new SendMessage();
        sm.setText(text);
        sm.setChatId(chatId);
        sm.setReplyMarkup(keyboard);
        try {
            shipsBot.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sentMessage (String chatId, String text){
        SendMessage sm = new SendMessage();
        sm.setText(text);
        sm.setChatId(chatId);
        try {
            shipsBot.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
