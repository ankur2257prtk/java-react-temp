package com.wellness.bot.Wellness_bot.controller;

import com.microsoft.bot.builder.Bot;
import com.microsoft.bot.builder.InvokeResponse;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.schema.Activity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/messages")
public class BotController {

    private final BotFrameworkHttpAdapter adapter;
    private final Bot bot;

    public BotController(BotFrameworkHttpAdapter adapter, Bot bot) {
        this.adapter = adapter;
        this.bot = bot;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<InvokeResponse>> processMessage(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader,
            @RequestBody Activity activity) {

        return adapter.processIncomingActivity(authHeader, activity, bot)
                .thenApply(ResponseEntity::ok);
    }

    // ✅ Define WellnessBot inside BotController
    public static class WellnessBot extends com.microsoft.bot.builder.ActivityHandler {

        @Override
        protected CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
            String userMessage = turnContext.getActivity().getText().toLowerCase();
            String response;

            switch (userMessage) {
                case "check-in":
                    response = "How are you feeling today? (Happy, Neutral, Stressed)";
                    break;
                case "happy":
                case "neutral":
                case "stressed":
                    response = "Thanks for your response! Your wellness check-in is recorded.";
                    break;
                case "reminder":
                    response = "I'll remind you to take breaks every hour! Stay hydrated 💧";
                    break;
                case "meditation":
                    response = "Here’s a guided meditation for you: [Click Here](https://www.youtube.com/watch?v=inpok4MKVLM)";
                    break;
                default:
                    response = "Sorry, I didn't understand. Try 'check-in', 'reminder', or 'meditation'.";
                    break;
            }

            return turnContext.sendActivity(MessageFactory.text(response))
                    .thenApply(resourceResponse -> null);
        }
    }
}
