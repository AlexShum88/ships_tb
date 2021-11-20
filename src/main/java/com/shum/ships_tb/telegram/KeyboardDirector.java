package com.shum.ships_tb.telegram;

import com.shum.ships_tb.ShipsBot;
import com.shum.ships_tb.repository.entity.RepoButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardDirector {
    private String commandForSelectShip = "/get_one_ship";
    public final String regexPoint = ":";

    private final Map<String, String> buttons;
    //todo get buttons from db, put into map, and have some builder methods to build different keyboards
    public KeyboardDirector(ShipsBot shipsBot, String language){
        this.buttons = buttonFromDb(shipsBot.getIbutton().findAll(), language);

    }

    private Map<String,String> buttonFromDb(List<RepoButton>listButt, String language){
        Map<String, String> buff = new HashMap<>();
        switch (language){
            case "ru":
                for(RepoButton rb:listButt){
                    buff.put(rb.getCommand(),rb.getRu());
                }
                break;
            default:
                for(RepoButton rb:listButt){
                    buff.put(rb.getCommand(),rb.getEn());
                }
                break;
        }
        return buff;
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
        Map<String, String> buttonParam = buttonsOfShips(shipsNames);
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
        for(String sh_name:shipsNames){
            newMap.put(String.format("%s%s%s",commandForSelectShip,regexPoint, sh_name), sh_name);
        }
        return newMap;
    }


}
