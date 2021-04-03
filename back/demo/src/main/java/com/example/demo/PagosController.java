package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PagosController{

    @Autowired
    private PagoRepository pagoRep;

    @Autowired
    private UsuarioRepository usuarioRep;

    Logger logger = LoggerFactory.getLogger(PagosController.class);

    @PostMapping("/user")
    public Pago registrarPago(@RequestBody PagoDTO pago) throws Exception
    {
        logger.info("Se intenta registrar un nuevo pago");
        String destiny = pago.getDestiny();

        if(usuarioRep.existsByUsername(destiny))
        {
            Pago nuevo = new Pago(pago.getSource(), pago.getDestiny(), pago.getValue());
            pagoRep.save(nuevo);
            logger.info("Se registra el pago exitosamente: "+nuevo.toString());
            return nuevo;
        }
        else
        {
            logger.error("Pago fallido, no existe el destinatario "+destiny);
            throw new Exception("El destinatario no existe");
        }
    }

    @GetMapping("/historico")
    public List<Pago> darHistorico()
    {
        logger.info("Se retorna el histórico de pagos");
        return pagoRep.findAll();
    }
}