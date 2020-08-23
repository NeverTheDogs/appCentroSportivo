package bottelegram;

import java.io.File;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class amazingBot extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return "780811258:AAHTLELbko2xhCDcrbdb4za3Xp8DPfy-Jj4";
    }
    
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            
            System.out.println(chat_id);
            switch (message_text) {
                case "/start":
                    {
                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("/foto -- Foto del museo\n/posizione -- Link di google maps\n/eventi -- Lista eventi\n/promozioni -- Possibili sconti e promozioni");
                        try {
                            message.enableHtml(true);
                            message.enableMarkdown(true);
                            message.enableWebPagePreview();
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }       break;
                    }
                case "/foto":
                    // User sent /pic
                    File f= new File("src/pic/foto.jpg");
                    SendPhoto msg = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto(f)
                            .setCaption("MuMe");
                    try {
                        execute(msg); // Call method to send the photo
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }   break;
                case "/posizione":
                    {
                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("http://bit.ly/2T5sJUJ");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }       break;
                    }
                case "/eventi":
                    {
                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Mostra Caravaggio - 25/12/2018\nConvegno di archeologia classica - 01/01/2019\nSeminario agiografia - 07-01-2019");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }       break;
                    }
                case "/promozioni":
                    {
                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Fine settimana -10% su tutte le prenotazioni\nGruppo minimo 10 persone -30% \nGuida per gruppo min 5 persone -20%");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }       break;
                    }
                default:
                    {
                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText("Comando sconosciuto!");
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }       break;
                    }
            }
        } 
    }
    
    @Override
    public String getBotUsername() {
        
        return "mume_bot";
    }
    
}