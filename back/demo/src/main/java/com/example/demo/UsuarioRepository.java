package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface UsuarioRepository extends JpaRepository<Usuario, String>{

    public Usuario findByUsername(String username);

    public boolean existsByUsername(String username);
}