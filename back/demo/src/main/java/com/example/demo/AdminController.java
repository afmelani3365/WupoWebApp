package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AdminController
{
    @Value("${externalapi.key}")
    private String apiKey;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/admin")
    public String consultarApi()
    {
        final String uri = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/USD";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        logger.info(result);
        
        return result;
    }
}