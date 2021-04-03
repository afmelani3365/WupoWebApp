package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
public class Usuario{

    @Id
    private String username;
    private String passwd;
    private String role;

    public Usuario(){}

    public Usuario(String nUsername, String nPasswd, String nRole)
    {
        username = nUsername;
        passwd = nPasswd;
        role = nRole;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public String getRole()
    {
        return role;
    }

    public void setUsername(String nUsername)
    {
        username = nUsername;
    }

    public void setPasswd(String nPasswd)
    {
        passwd = nPasswd;
    }

    public void setRole(String nRole)
    {
        role = nRole;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o){
            return true;
        }
        if(!(o instanceof Usuario)){
            return false;
        }
        Usuario u = (Usuario)o;

        return Objects.equals(this.username, u.username) && Objects.equals(this.passwd, u.passwd) && Objects.equals(this.role, u.role);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.username, this.passwd, this.role);
    }

    @Override
    public String toString(){
        return "Usuario{" + "username='"+username+"',passwd='"+passwd+"',role='"+role+"'}";
    }
}