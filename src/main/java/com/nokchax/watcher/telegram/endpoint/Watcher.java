package com.nokchax.watcher.telegram.endpoint;

import com.nokchax.watcher.telegram.botconfig.Bot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class Watcher extends TelegramLongPollingBot {
    private final Bot bot;


    @Override
    public void onUpdateReceived(Update update) {
        //when message come from outside

    }

    @Override
    public String getBotUsername() {
        return bot.getName();
    }

    @Override
    public String getBotToken() {
        return bot.getToken();
    }
}
