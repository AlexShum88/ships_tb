package com.shum.ships_tb.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardBuilder {

    List<InlineKeyboardButton> row = new ArrayList();


    public List<InlineKeyboardButton> getRow() {
        return row;
    }


    public InlineKeyboardButton buildButton(String callBackData, String text) {
        /**make inline button*/
        InlineKeyboardButton button = new InlineKeyboardButton(text);
        button.setCallbackData(callBackData);
        row.add(button);
        return button;
    }

    public InlineKeyboardMarkup buildResualt(){
        /**build simple InlineKeyboardMarkup of buttons*/
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(getRow());
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }


}
