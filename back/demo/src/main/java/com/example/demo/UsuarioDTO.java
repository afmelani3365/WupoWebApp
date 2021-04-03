package com.example.demo;

public class UsuarioDTO{

    private String username;

    private String passwd;

    public String getUsername()
    {
        return username;
    }

    public String getPasswd()
    {
        return passwd;
    }
    
    public void setUsername(String nUsername)
    {
        username = nUsername;
    }

    public void setPasswd(String nPasswd)
    {
        passwd = nPasswd;
    }
}