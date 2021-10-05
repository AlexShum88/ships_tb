package com.shum.ships_tb.telegram;

import com.shum.ships_tb.ShipsBot;
import com.shum.ships_tb.commands.*;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;
//invocator in command pattern for telegram commands
public class CommandListener {
    private Map<String, TelegramCommand> commands = new HashMap();
    private Map<String, String>messageListener = new HashMap();
    private final ShipsBot shipsBot;
    private final KeyboardDirector keyboardDirector;
    private final Messager messager;

    public CommandListener(ShipsBot shipsBot) {
        this.shipsBot = shipsBot;
        this.keyboardDirector = new KeyboardDirector();
        this.messager = new Messager(shipsBot);
        /**
         * set links with commands what we get, and obj of command*/
        commands.put("/show_my_ships", new ViewMyShipITC(keyboardDirector, messager, this.shipsBot.getIShip()));
        //commands.put("/new_ship");
        commands.put("/enter_name", new EnterNameITC(keyboardDirector, messager, this));
        commands.put("/get_name", new GetNameITC(keyboardDirector, messager));
        commands.put("/create_new_ship", new CreateNewShipITC(keyboardDirector, messager));
        commands.put("/return", new ReturnITC(keyboardDirector, messager));
        commands.put("", new StartITC(keyboardDirector, messager));

    }


    public void getCallBackUpdate(Update update){
        /**
         * receive callback and take critical data*/
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String command = update.getCallbackQuery().getData();
        toExec(chatId, command);
    }

    private void toExec(String chatId, String command){
        /**
         * execute command main method*/
        commands.get(command).execute(chatId);
    }

    private void toExec(String chatId, String command, String text){
        /**
         * execute command mail method where need to set text*/
        var res = (SetTextInlineTelegramCommand) commands.get(command) ;
        res.setTextAndExecute(chatId, text);
    }

    public void setMessageListener(String chatId, String command) {
        /** set in map chatId and next command to catch text message*/
        this.messageListener.put(chatId, command);
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
