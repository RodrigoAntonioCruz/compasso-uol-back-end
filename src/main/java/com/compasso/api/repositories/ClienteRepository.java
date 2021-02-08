package com.compasso.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.compasso.api.models.Cliente;

/**
*
* @author  Rodrigo da Cruz
* @version 1.0
* @since   2021-01-22 
* 
*/

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
	
}
