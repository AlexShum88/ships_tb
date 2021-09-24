package com.shum.ships_tb;



import com.shum.ships_tb.gameObj.Ship;
import com.shum.ships_tb.repository.entity.RepoCargo;
import com.shum.ships_tb.repository.entity.RepoPort;
import com.shum.ships_tb.service.BotService;
import com.shum.ships_tb.service.cargo.ICargo;
import com.shum.ships_tb.service.port.IPort;
import com.shum.ships_tb.service.ship.IShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class ShipsBot extends TelegramLongPollingBot {

    private final BotService botService;
    private final ICargo icargo;
    private IShip iShip;
    private final IPort iPort;
    //collections need that no ask db every time we need this template
    public static List<RepoCargo> listCargo; //collections of cargos
    public static List<RepoPort> listRepoPort; // collections of ports

    @Autowired
    public ShipsBot(BotService botService, ICargo icargo, IShip iShip, IPort iPort) {
        this.botService = botService;
        this.icargo = icargo;
        this.iShip = iShip;
        this.iPort = iPort;
        listCargo = icargo.findAll();
        listRepoPort = iPort.findAll();
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

            //second test block
            testShipCargoOperations(chatId);
            //end second test block



            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo its only echo. need normal realisation
                e.printStackTrace();
            }
        }
    }
    private void testSendMessageWithShipsCargo(String chatId) {
        SendMessage sm = new SendMessage();
        //test block
        System.out.println(ShipsBot.listCargo.get(0).getName());
        Ship ship = new Ship(iShip.findById(1, iShip.findByOwner("me")));

        for (int i = 0; i <ship.getCargo().size() ; i++) {
            sm.setChatId(chatId);
            sm.setText(ship.getCargo().get(i).getName());
            try {
                execute(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void testShipCargoOperations(String chatId) {
        SendMessage sm = new SendMessage();
        Ship ship = new Ship(iShip.findById(1, iShip.findByOwner("me")));
        ship.setCargo("pinapple", 5);
        ship.setCargo("shit", 2);
        ship.removePieceOfCargo("screw", 31);
        //ship.removeCargo("apple");
        iShip.save(ship);
        testSendMessageWithShipsCargo(chatId);
    }
}
