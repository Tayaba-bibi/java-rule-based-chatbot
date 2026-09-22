import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 * Project 1: Rule-Based AI Chatbot (Java Version)
 */
public class ChatBot {

    public static void main(String[] args) {

        // ---------------------------------------------------------
        // PHASE 2: KNOWLEDGE BASE
        // HashMap gives O(1) lookup, just like Python's dictionary
        // ---------------------------------------------------------
        HashMap<String, String> responses = new HashMap<>();
        responses.put("hello", "Hi there! How can I help you today?");
        responses.put("hi", "Hello! Nice to see you.");
        responses.put("how are you", "I'm just a program, but I'm running smoothly! How about you?");
        responses.put("what is your name", "I'm RuleBot, a simple rule-based assistant built at DecodeLabs.");
        responses.put("help", "I can respond to greetings, tell you my name, and chat a little. Try 'hello', 'how are you', or 'what is your name'.");
        responses.put("thank you", "You're welcome!");
        responses.put("thanks", "Anytime!");

        // Commands that end the conversation
        Set<String> exitCommands = Set.of("exit", "bye", "quit", "goodbye" );

        Scanner scanner = new Scanner(System.in);
        System.out.println("RuleBot: Hello Tayaba ! I'm your rule-based assistant. Type 'exit' or 'bye' to end our chat.");

        // ---------------------------------------------------------
        // THE HEARTBEAT: infinite loop until exit command
        // ---------------------------------------------------------
        while (true) {

            //  INPUT & SANITIZATION
            System.out.print("You: ");
            String rawInput = scanner.nextLine();
            String cleanInput = rawInput.toLowerCase().trim();

            // EXIT STRATEGY
            if (exitCommands.contains(cleanInput)) {
                System.out.println("RuleBot: Goodbye! Have a great day.");
                break;
            }

            // Skip empty input
            if (cleanInput.isEmpty()) {
                continue;
            }

            // PROCESS + OUTPUT
            // getOrDefault() is Java's equivalent of Python's .get(key, default)
            String reply = responses.getOrDefault(cleanInput, "I do not understand. Type 'help' to see what I can do.");
            System.out.println("RuleBot: " + reply);
        }

        scanner.close();
    }
 }


