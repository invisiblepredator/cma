package com.gpw.cma.domain.repository;

import com.gpw.cma.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CMARepository extends JpaRepository<Client, String> {

}
