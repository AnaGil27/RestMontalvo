package cibertec.edu.pe.RestMontalvo.repository;

import cibertec.edu.pe.RestMontalvo.model.bd.DescManicura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DescManicuraRepository  extends JpaRepository<DescManicura,Integer> {
    Optional<DescManicura> findByDescripcion(String descripcion);

    List<DescManicura> findByDescripcionContainingIgnoreCase(String filtro);

    @Query("SELECT d FROM DescManicura d WHERE d.descripcion LIKE %:filtro%")
    List<DescManicura> filtrardescmanicura(@Param("filtro") String filtro);


    @Query(value = "SELECT * FROM descmanicura WHERE descripcion LIKE %:filtro%",
            nativeQuery = true)
    List<DescManicura> filtrardescmanicuraPorNombreSQL(@Param("filtro") String filtro);

}


