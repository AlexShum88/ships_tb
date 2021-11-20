package com.shum.ships_tb.telegram;

import com.shum.ships_tb.ShipsBot;
import com.shum.ships_tb.commands.*;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class CommandDirector {
    @Getter
    private Map<String, TelegramCommand> commands = new HashMap();
    private final ShipsBot shipsBot;
    private final KeyboardDirector keyboardDirector;
    private final Messager messager;


    public CommandDirector(ShipsBot shipsBot, KeyboardDirector keyboardDirector, Messager messager) {
        this.shipsBot = shipsBot;
        this.keyboardDirector = keyboardDirector;
        this.messager = messager;
        /** set links with commands what we get, and obj of command*/
        //uncomment than its ready
        commands.put("/show_my_ships", new ShowMyShipsITC(keyboardDirector, messager, this.shipsBot.getIShip()));
        //commands.put("/enter_name", new EnterNameITC(keyboardDirector, messager, this));
        //commands.put("/get_name", new GetNameITC(keyboardDirector, messager));
        commands.put("/create_new_ship", new CreateNewShipITC(keyboardDirector, messager, this.shipsBot.getIshipType()));
        //commands.put("/return", new ReturnITC(keyboardDirector, messager));
        commands.put("", new StartITC(keyboardDirector, messager));
        //commands.put("/show_player_status");
        commands.put("/get_one_ship", new GetOneShipITC(keyboardDirector, messager, this.shipsBot.getIShip()));
        //commands.put("/set_destination_point");
        //commands.put("/refuel");
        //commands.put("/show_location_parameters");
        //commands.put("/load_cargo");
        //commands.put("/unload_cargo");
        //commands.put("/send_ship");
        //commands.put("/what_cargo");
        //commands.put("/how_much");
        //commands.put("/get_num");
        //commands.put("/name_new_ship");
        //commands.put("/get_ship_name");
        commands.put("/get_ship_class", new GetShipClassITC(keyboardDirector, messager));
        //commands.put("/ship_ready");
    }


}
