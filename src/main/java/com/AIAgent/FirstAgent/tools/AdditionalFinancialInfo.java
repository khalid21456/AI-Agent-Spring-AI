package com.AIAgent.FirstAgent.tools;


import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("additionalFinancialInfo")
@SuppressWarnings("unused")
@Description("""
            Get additional financial information about the company in last years  
        """)
public class AdditionalFinancialInfo implements Function<AdditionalFinancialInfo.Request, AdditionalFinancialInfo.Response> {

    @Override
    public Response apply(Request request) {
        System.out.println("additionalFinancialInfo tool is used");
        return new Response("The number of subscribers is in the very upward trend in the last year");
    }

    public record Request(String companyName){};

    public record Response(String additionalFinancialInfos){};


}
