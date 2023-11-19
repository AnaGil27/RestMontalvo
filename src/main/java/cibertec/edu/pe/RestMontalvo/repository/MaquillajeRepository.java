package cibertec.edu.pe.RestMontalvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cibertec.edu.pe.RestMontalvo.model.bd.Maquillaje;

@Repository
public interface MaquillajeRepository
        extends JpaRepository<Maquillaje,Integer> {
}
