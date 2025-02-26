package com.wellness.bot.Wellness_bot.bot;

import com.microsoft.bot.builder.Bot;
import com.microsoft.bot.integration.AdapterWithErrorHandler;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.Configuration;
import com.microsoft.bot.integration.spring.BotDependencyConfiguration;
import com.wellness.bot.Wellness_bot.controller.BotController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;


@org.springframework.context.annotation.Configuration
public class BotConfig extends BotDependencyConfiguration {

    @Value("${MicrosoftAppId:}") // ✅ Load from application.properties, default empty
    private String microsoftAppId;

    @Value("${MicrosoftAppPassword:}") // ✅ Load from application.properties, default empty
    private String microsoftAppPassword;

    @Bean
    @Override
    public BotFrameworkHttpAdapter getBotFrameworkHttpAdaptor(Configuration configuration) {
        return new AdapterWithErrorHandler(configuration);
    }

    // ✅ Register the WellnessBot as a Bean
    @Bean
    public Bot getBot() {
        return new BotController.WellnessBot();
    }

}