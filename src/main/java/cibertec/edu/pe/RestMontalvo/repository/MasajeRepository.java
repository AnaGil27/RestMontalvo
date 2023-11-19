package cibertec.edu.pe.RestMontalvo.repository;

import cibertec.edu.pe.RestMontalvo.model.bd.Masaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasajeRepository extends JpaRepository<Masaje,Integer> {
}
