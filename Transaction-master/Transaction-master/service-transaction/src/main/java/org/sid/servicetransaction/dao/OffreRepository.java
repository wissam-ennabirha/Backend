package org.sid.servicetransaction.dao;

import org.sid.servicetransaction.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OffreRepository extends JpaRepository<Offre, Long>{

}
