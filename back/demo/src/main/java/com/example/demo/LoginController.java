package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoginController
{
    @Autowired
    private UsuarioRepository usuarioRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProv;

    @Autowired
    private AuthenticationManager authManager;

    Logger logger = LoggerFactory.getLogger(PagosController.class);

    @PostMapping("/")
    public LoginDTO login(@RequestBody UsuarioDTO usuario) throws Exception
    {
        String username = usuario.getUsername();
        String passwd = usuario.getPasswd();
        logger.info("Intento de inicio de sesión: "+username);
        if(usuarioRep.existsByUsername(username))
        {
            
            //UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, passwd);
            //Authentication auth = authManager.authenticate(authReq);
            Usuario user = usuarioRep.findByUsername(username);
                
            if(passwordEncoder.matches(passwd, user.getPasswd()))
            {
                logger.info("Inicio de sesión correcto: "+user.toString());
                String tok = jwtTokenProv.createToken(username, usuarioRep.findByUsername(username).getRole());

                return new LoginDTO(tok, true);
            }
            else
            {
                logger.error("Error de credenciales al iniciar sesión");
                throw new BadCredentialsException("Contraseña incorrecta");
            }
        }
        else
        {
            return registrar(username, passwd);
        }
    }

	public LoginDTO registrar(String username, String passwd)
	{
        logger.info("Se procede a registrar un nuevo usuario: "+username);
        String pwdCifrada = passwordEncoder.encode(passwd);
		Usuario nuevo = new Usuario(username, pwdCifrada, "client");
        usuarioRep.save(nuevo);
        logger.info("Registrado nuevo usuario: "+nuevo.toString());
        return new LoginDTO("Como no existía el usuario, se ha creado uno nuevo", false);
	}
}