package ma.emsi.moughit.tp3moughit.llm;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class GuideTouristiqueService {

    private static final Logger LOGGER = Logger.getLogger(GuideTouristiqueService.class.getName());
    private final GuideTouristique guide;

    public GuideTouristiqueService() {
        String apiKey = System.getenv("GEMINI_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new RuntimeException("The GEMINI_KEY environment variable is not set.");
        }



        guide = AiServices.builder(GuideTouristique.class).chatLanguageModel(GoogleAiGeminiChatModel.builder()
                        .apiKey(apiKey)
                        .modelName("gemini-2.5-flash")
                        .build())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }

    public String getGuide(String lieu) {
        try {
            return guide.getGuide(lieu);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error calling LLM service", e);
            // Retourner un message d'erreur JSON
            return "{\"error\": \"Failed to get guide from LLM: " + e.getMessage() + "\"}";
        }
    }
}


