package com.example.demo;

public class PagoDTO
{
    private String source;

    private String destiny;

    private Double value;

    public String getSource()
    {
        return source;
    }

    public String getDestiny()
    {
        return destiny;
    }

    public Double getValue()
    {
        return value;
    }

    public void setSource(String nSource)
    {
        source = nSource;
    }

    public void setDestiny(String nDestiny)
    {
        destiny = nDestiny;
    }

    public void setValue(Double nValue)
    {
        value = nValue;
    }
}