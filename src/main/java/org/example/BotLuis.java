package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotLuis extends TelegramLongPollingBot{
    @Override
    public String getBotUsername() {
        return "luis101bot";
    }


    @Override
    public String getBotToken(){
        return "6693599238:AAED6e0ybW7AxNCAAG1LTHMnN0DaLw7mt-c";
    }
    @Override
    public void onUpdateReceived(Update update) {

        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        System.out.println("Mensaje recibido: " + message);
        int length = message.length();
        System.out.println("El mensaje tiene " + length + " caracteres");

        sendMessage(generateSendMessage(chatId, length));
    }

    private SendMessage generateSendMessage(Long chatId, int characterCount) {
        return new SendMessage(chatId.toString(), "El mensaje tiene " + characterCount + " caracteres");
    }
    private void sendMessage(SendMessage sendMessage){
        try{
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
