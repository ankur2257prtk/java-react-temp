package com.wellness.bot.Wellness_bot.controller;

import com.microsoft.bot.builder.*;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.schema.ActivityTypes;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.schema.ResourceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/messages")
public class BotController extends ActivityHandler {

    @PostMapping
    public CompletableFuture<ResourceResponse> handleIncoming(@RequestBody TurnContext turnContext) {
        if (turnContext.getActivity().getType().equals(ActivityTypes.MESSAGE)) {
            return handleUserMessage(turnContext);
        }
        return CompletableFuture.completedFuture(null);
    }

    private CompletableFuture<ResourceResponse> handleUserMessage(TurnContext  turnContext) {
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

        Activity reply = MessageFactory.text(response);
        return turnContext.sendActivity(reply);
    }
}
