
# Wellness Bot - Spring Boot + Microsoft Bot Emulator

## Overview
The Wellness Bot is a conversational bot built with **Spring Boot** and the **Microsoft Bot Framework**. The bot provides users with wellness check-ins, break reminders, and mindfulness exercises. This bot can be tested locally using the Microsoft Bot Framework Emulator.

### Features:
- **Wellness Check-ins**: Users can check in daily with their mood (Happy, Neutral, Stressed).
- **Break Reminders**: Sends hourly reminders for hydration and stretching.
- **Mindfulness Exercises**: Provides guided meditation videos and breathing guides.

## Project Setup

### Prerequisites:
Before you begin, ensure you have the following installed:
- **Java 17+** (for Spring Boot)
- **Maven** (for dependency management)
- **Spring Boot** (for the backend)
- **Microsoft Bot Framework Emulator** (for local testing)
- **Postman** or any API testing tool for testing the API endpoints.

#### Project-structure
```
wellness-buddy-backend
│── src/main/java/com/wellnessbuddy
│   ├── bot
│   │   ├── WellnessBot.java
│   │   ├── BotController.java
│   ├── config
│   │   ├── GraphApiConfig.java
│   │   ├── SecurityConfig.java
│   ├── controller
│   │   ├── CalendarController.java
│   │   ├── WellnessController.java
│   ├── service
│   │   ├── CalendarService.java
│   │   ├── WellnessService.java
│   ├── model
│   │   ├── Meeting.java
│   │   ├── UserBreak.java
│   ├── repository
│   │   ├── MeetingRepository.java
│   │   ├── UserBreakRepository.java
│   ├── WellnessBuddyApplication.java
│── src/main/resources
│   ├── application.properties
│── pom.xml
```

### Steps to Run the Application

1. Set up dependencies: Run the following command to build the project and install dependencies:

mvn clean install

2. Run the application: To start the Spring Boot application, run:
   mvn spring-boot:run
3. Test the bot locally: Open Microsoft Bot Framework Emulator and connect to the bot by entering the following endpoint: http://localhost:8080/api/messages
4. Interact with the bot: In the emulator, you can type various commands like:

 * check-in: Starts the wellness check-in process. 
 * happy, neutral, stressed: Responds to the wellness check-in with a recorded message.
 * reminder: Sends reminders for hydration/stretching.
meditation: Provides a link to a guided meditation video.

### Code Explanation

##### BotController.java
* The BotController class exposes an API endpoint at /api/messages where incoming messages are processed. 
* It handles interactions using a Bot instance, defined inside the WellnessBot class. 
* processMessage: Handles incoming messages and passes them to the bot for processing. 
* WellnessBot: A subclass of ActivityHandler where different commands are processed:
* check-in: Prompts the user for their mood. 
* happy, neutral, stressed: Records the user's mood response. 
* reminder: Sends a break reminder. 
* meditation: Shares a link to a meditation video.

##### Sample Responses
* check-in: "How are you feeling today? (Happy, Neutral, Stressed)"
* happy/neutral/stressed: "Thanks for your response! Your wellness check-in is recorded."
* reminder: "I'll remind you to take breaks every hour! Stay hydrated 💧"
* meditation: "Here’s a guided meditation for you: Click Here"

##### Example API Response

* When the bot doesn't understand the message, it responds with:
  * json
```
    {
    "type": "message",
    "text": "Sorry, I didn't understand. Try 'check-in', 'reminder', or 'meditation'."
    }
```
  * Testing the Bot

    * You can test the bot using Microsoft Bot Framework Emulator or by sending requests directly to the /api/messages endpoint. For testing API calls, you can use Postman to send JSON payloads to the bot.

    * Example Postman Request:

      * URL: POST http://localhost:8080/api/messages

      * Headers:

      * Authorization: <Authorization Token>

      * Body:

      * json

      * {
"type": "message",
"text": "check-in"
}
      * Troubleshooting:
        * Ensure the application is running on http://localhost:8080. 
        * Verify that the Microsoft Bot Emulator is connected to the correct endpoint (http://localhost:8080/api/messages). 
        * If the bot doesn't respond, check the console for error messages or exceptions