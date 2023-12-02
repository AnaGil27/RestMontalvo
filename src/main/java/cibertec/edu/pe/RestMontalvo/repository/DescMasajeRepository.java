package cibertec.edu.pe.RestMontalvo.repository;

import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DescMasajeRepository extends JpaRepository<DescMasaje,Integer> {
    Optional<DescMasaje> findByNombremasaje(String nombremasaje);

    List<DescMasaje> findByNombremasajeContainingIgnoreCase(String filtro);

    @Query("SELECT c FROM DescMasaje c WHERE c.nombremasaje LIKE %:filtro%")
    List<DescMasaje> filtrardescmasaje(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM descmasaje WHERE nombremasaje LIKE %:filtro%",
            nativeQuery = true)
    List<DescMasaje> filtrardescmasajeSQL(@Param("filtro") String filtro);

}
