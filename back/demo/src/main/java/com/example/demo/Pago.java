package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="payments")
public class Pago{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String destiny;
    private Double value;

    public Pago(){}

    public Pago(String nSource, String nDestiny, Double nValue)
    {
        source = nSource;
        destiny = nDestiny;
        value = nValue;
    }

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

    @Override
    public boolean equals(Object o)
    {
        if(this == o){
            return true;
        }
        if(!(o instanceof Pago)){
            return false;
        }
        Pago p = (Pago)o;

        return Objects.equals(this.id, p.id) && Objects.equals(this.source, p.source) && Objects.equals(this.destiny, p.destiny) && Objects.equals(this.value, p.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.source, this.destiny, this.value);
    }

    @Override
    public String toString(){
        return "Pago{" + "id="+id+",source='"+source+"',destiny='"+destiny+"',value="+value+"}";
    }
}