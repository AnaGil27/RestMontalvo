package cibertec.edu.pe.RestMontalvo.repository;

import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DescMasajeRepository extends JpaRepository<DescMasaje,Integer> {
    Optional<DescMasaje> findByDescMasaje(String desc_masaje);

    List<DescMasaje> findBydesc_masajeContainingIgnoreCase(String filtro);

    @Query("SELECT c FROM DescMasaje c WHERE c.desc_masaje LIKE %:filtro%")
    List<DescMasaje> filtrardesc_masaje(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM DescMasaje WHERE desc_masaje LIKE %:filtro%",
            nativeQuery = true)
    List<DescMasaje> filtrardesc_masajeSQL(@Param("filtro") String filtro);
}
