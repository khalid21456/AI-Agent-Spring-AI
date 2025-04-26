package com.AIAgent.FirstAgent;


import com.AIAgent.FirstAgent.agents.FinancialAnalysisAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class MyAiAgentController {

    private ChatClient chatClient;

    @Autowired
    private FinancialAnalysisAgent financialAnalysisAgent;

    String systemPrompt = """
                You will be asked to generate financial report about a given company using actual financial data
                Your report should include information about the company (name,country,domain) 
                Your report should include a concise conclusion about analysis and a definition about the founder
            """;

    public MyAiAgentController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping(value = "/financialAnalysis", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String askAgent(@RequestParam String company) {
        return financialAnalysisAgent.financialAnalysisReport(company);
    }
}
