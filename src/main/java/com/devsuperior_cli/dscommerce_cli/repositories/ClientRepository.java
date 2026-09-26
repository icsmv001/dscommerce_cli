package com.devsuperior_cli.dscommerce_cli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior_cli.dscommerce_cli.entities.Client;

public interface ClientRepository extends  JpaRepository<Client, Long>{

}
