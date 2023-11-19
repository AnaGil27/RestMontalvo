package cibertec.edu.pe.RestMontalvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import cibertec.edu.pe.RestMontalvo.model.bd.DescPeinado;

import java.util.List;
import java.util.Optional;

@Repository
public interface DescPeinadoRepository extends JpaRepository<DescPeinado,Integer>{

    Optional<DescPeinado> findByDescPeinadoname(String desc_peinado);

    List<DescPeinado> findByDescPeinadonameContainingIgnoreCase(String filtro);

    @Query("SELECT d FROM DescPeinado d WHERE d.desc_peinado LIKE %:filtro%")
    List<DescPeinado> filtrarDescPeinadoPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM descpeinado WHERE desc_peinado LIKE %:filtro%",
            nativeQuery = true)
    List<DescPeinado> filtrarDescPeinadoPorNombreSQL(@Param("filtro") String filtro);



}