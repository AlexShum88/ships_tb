package com.shum.ships_tb.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardDirector {
    private final Map<String, String> buttons= new HashMap();
    //todo get buttons from db, put into map, and have some builder methods to build different keyboards
    public KeyboardDirector(){
        //this.buttons = buttons;//todo need method to receive data from db

        //now its just manual added buttons data for testing
        buttons.put("/show_my_ships", "show ships");
        buttons.put("/return", "return");
        buttons.put("/enter_name","enter name");
        buttons.put("/create_new_ship","/create_new_ship");
        buttons.put("/new_ship","/new_ship");

    }



    private InlineKeyboardMarkup productor(Map<String, String> buttonParam){
        /**get ready data to use with keyboardBuilder*/
        KeyboardBuilder builder = new KeyboardBuilder();
        for (Map.Entry<String, String> entry: buttonParam.entrySet()) {
            builder.buildButton(entry.getKey(), entry.getValue() );
        }
        return builder.buildResualt();
    }

    public InlineKeyboardMarkup productor(String ...commands){
        Map<String, String> buttonParam = selectButtonsWithCommand(commands);
        return productor(buttonParam);
    }

    public InlineKeyboardMarkup productor(List<String> shipsNames){
        Map<String, String> buttonParam = buttonsOfShips( shipsNames);
        return productor(buttonParam);
    }

    private Map<String, String> selectButtonsWithCommand ( String ...commands) {
        /**get massive of command and look for it in list of button. Return map of finding button*/
        Map<String, String > newMap = new HashMap<>();
        for (String comm:commands ) {
            if (buttons.containsKey(comm)){
                newMap.put(comm, buttons.get(comm));
            }
        }
        return newMap;
    }

    private Map<String, String> buttonsOfShips(List<String> shipsNames){
        /**get list of ship names and return map of button of this ships*/
        Map<String, String > newMap = new HashMap<>();
        //todo get list of ships name of current owner and make map where command be such us "/select_ship_by_name"
        return newMap;
    }


}
