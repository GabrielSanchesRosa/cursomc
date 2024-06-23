package com.cusomc.repositories;

import com.cusomc.domain.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional
    Cliente findByEmail(String email);
}
