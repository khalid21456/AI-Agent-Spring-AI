package com.AIAgent.FirstAgent;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class MyAiAgentController {

    private ChatClient chatClient;

    String systemPrompt = """
                You will be asked to generate financial report about a given company using actual financial data
                Your report should include information about the company (name,country,domain) 
                Your report should include a concise conclusion about analysis
            """;

    public MyAiAgentController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping(value = "/financialAnalysis", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String askAgent(@RequestParam String company) {
        return chatClient.prompt().system(systemPrompt)
                .user("Company Name : "+company)
                .functions("countryIdentityInfo","financialDataTool","additionalFinancialInfo")
                .call().content();
    }
}
