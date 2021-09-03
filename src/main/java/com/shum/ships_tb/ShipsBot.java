package com.shum.ships_tb;

import com.shum.ships_tb.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class ShipsBot extends TelegramLongPollingBot {

    private final BotService botService;

    @Autowired
    public ShipsBot(BotService botService) {
        this.botService = botService;
    }



    @Override
    public String getBotUsername() {
        //get bot name from db
        return botService.findByName().get(0).getName();
    }

    @Override
    public String getBotToken() {
        //get bot token from db
        return botService.findByName().get(0).getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo its only echo. need normal realisation
                e.printStackTrace();
            }
        }
    }
}
