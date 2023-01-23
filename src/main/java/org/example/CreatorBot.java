package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreatorBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "superxcreatorbot";
    }

    @Override
    public String getBotToken() {
        return "5472230778:AAFZ7IIcaZVNdRsesLoamfyvd1rzTiVvQMQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        switch (command) {
            case "/start":
                message.setText("Welcome to Creator Bot");
                break;
            case "/end":
                message.setText("Thanks you for using Creator Bot");
                break;
            default:
                message.setText("Invalid command");
                break;
        }

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
