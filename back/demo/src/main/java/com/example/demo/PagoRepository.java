package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface PagoRepository extends JpaRepository<Pago, Long>{

    public List<Pago> findBySourceAndDestiny(String source, String destiny);

    public List<Pago> findBySource(String source);

    public List<Pago> findByDestiny(String destiny);
}