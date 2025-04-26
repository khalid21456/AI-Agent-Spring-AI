package com.AIAgent.FirstAgent.tools;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@SuppressWarnings("unused")

@Description("""
            Get Identity Information about a given company including :
            - The name of the company
            - The founder of the company
            - The country of the company
            - The industry domain of the company
            - The founded year of the company
        """)
@Service("countryIdentityInfo")
public class CountryIdentityInfo implements Function<CountryIdentityInfo.Request, CountryIdentityInfo.Response> {

    // Add repositories to receive data from DB

    @Override
    public Response apply(Request request) {
        System.out.println("countryIdentityInfo tool is used");
        return new Response(request.companyName(), "Mohamed Benchaâboun","Morocco","Telephone",1911);
    }

    public record Request(String companyName){};

    public record Response(
            String CompanyName,
            String founder,
            String country,
            String industryDomain,
            int foundedYear
    ){};

}
