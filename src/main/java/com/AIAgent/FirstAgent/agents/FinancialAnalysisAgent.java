package com.AIAgent.FirstAgent.agents;


import com.AIAgent.FirstAgent.annotations.AiAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
@AiAgent
public class FinancialAnalysisAgent {
    private ChatClient chatClient;

    public FinancialAnalysisAgent(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    /*
     public FinancialAnalysisAgent(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultSystem(systemPrompt)
                .defaultFunctions(tools)
                .build();
    }
    */

    private String[] tools = new String[]{"countryIdentityInfo","financialDataTool","additionalFinancialInfo"};

    String systemPrompt = """
                You will be asked to generate financial report about a given company using actual financial data
                Your report should include information about the company (name,country,domain) 
                Your report should include a concise conclusion about analysis and a definition about the founder
            """;

    public String financialAnalysisReport(String companyName) {
        return chatClient.prompt().system(systemPrompt)
                .user("Company Name : "+companyName)
                .functions(tools)
                .call().content();
    }
}
