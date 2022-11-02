package com.ilussencio.CRUD_Cliente.repositories;

import com.ilussencio.CRUD_Cliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
