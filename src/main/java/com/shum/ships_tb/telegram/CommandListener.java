package com.shum.ships_tb.telegram;

import com.shum.ships_tb.ShipsBot;
import com.shum.ships_tb.commands.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;
//invocator in command pattern for telegram commands
public class CommandListener {
    private Map<String, TelegramCommand> commands;
    private Map<String, String>messageListener = new HashMap();
    private final ShipsBot shipsBot;
    private final KeyboardDirector keyboardDirector;
    private final Messager messager;
    private final CommandDirector commandDirector;

    public CommandListener(ShipsBot shipsBot) {
        this.shipsBot = shipsBot;
        this.keyboardDirector = new KeyboardDirector(shipsBot, "en"); //todo set language from users preferences
        this.messager = new Messager(shipsBot);
        this.commandDirector = new CommandDirector(this.shipsBot, this.keyboardDirector, this.messager);
        this.commands = commandDirector.getCommands();
    }


    public void getCallBackUpdate(Update update){
        /**
         * receive callback and take critical data*/
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String command = update.getCallbackQuery().getData();
        if (command.contains(keyboardDirector.regexPoint)){
            var buff = command.split(keyboardDirector.regexPoint);
            toExec(chatId, buff[0], buff[1]);
        }else toExec(chatId, command);
        delKeyB(update);
    }

    private void delKeyB (Update update){
        /**delete inline keyboard after get callback*/
        var emr = new EditMessageReplyMarkup();
        emr.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        emr.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        emr.setReplyMarkup(null);
        try {
            shipsBot.execute(emr);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void toExec(String chatId, String command){
        /**execute command main method*/
        commands.get(command).execute(chatId);
    }

    private void toExec(String chatId, String command, String text){
        /**execute command mail method where need to set text*/
        var res = (SetTextInlineTelegramCommand) commands.get(command) ;
        res.setTextAndExecute(chatId, text);
    }

    public void setMessageListener(String chatId, String command) {
        /** set in map chatId and next command to catch text message*/
        this.messageListener.put(chatId, command);
        //todo think about how delete keyboard after that start
        //answer: set deleter in commands
    }

    public void getMessageUpdate(Update update){
        /**
         * receive message if its have not callback data and get start command*/
        String chatId = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();
        String command = "";
        if(this.messageListener.containsKey(chatId)){
            command = this.messageListener.remove(chatId);
            toExec(chatId, command, text);
        }

    }


}
