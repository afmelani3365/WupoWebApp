package com.example.demo;

public class LoginDTO
{
    private String token;

    private Boolean success;

    public LoginDTO(String nToken, Boolean nSuccess)
    {
        token = nToken;
        success = nSuccess;
    }

    public String getToken()
    {
        return token;
    }

    public Boolean getSuccess()
    {
        return success;
    }
}