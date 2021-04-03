package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController{

    private final static String template = "Bienvenido a la app, %s!";
    
    private UsuarioRepository userRep;

    public SaludoController(UsuarioRepository rep)
    {
        userRep = rep;
    }

    @GetMapping("/saludar")
    public Saludo saludo(@RequestParam(value = "username") String username)
    {
        System.out.println(username);
        Usuario buscado = userRep.findByUsername(username);
        String name = "None";
        if(buscado != null)
        {
            System.out.println(buscado.toString());
            name = buscado.getUsername();
        }
        return new Saludo(String.format(template, name));
    }

    @GetMapping("/usuarios")
    public List<Usuario> darUsuarios()
    {
        return userRep.findAll();
    }
}