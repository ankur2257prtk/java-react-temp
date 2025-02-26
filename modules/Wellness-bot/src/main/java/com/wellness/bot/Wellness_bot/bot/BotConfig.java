package com.wellness.bot.Wellness_bot.bot;

//import com.microsoft.bot.integration.Configuration;
import com.microsoft.bot.integration.AdapterWithErrorHandler;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.Configuration;
import com.microsoft.bot.integration.spring.BotDependencyConfiguration;
import org.springframework.beans.factory.annotation.Value;


@org.springframework.context.annotation.Configuration
public class BotConfig extends BotDependencyConfiguration {
//    public BotConfig(Configuration configuration) {
//        super(configuration);
//    }

    @Override
    public BotFrameworkHttpAdapter getBotFrameworkHttpAdaptor(Configuration configuration) {
        return new AdapterWithErrorHandler(configuration);
    }

    @Value("${MicrosoftAppId:}") // ✅ Load from application.properties, default empty
    private String microsoftAppId;

    @Value("${MicrosoftAppPassword:}") // ✅ Load from application.properties, default empty
    private String microsoftAppPassword;
}
