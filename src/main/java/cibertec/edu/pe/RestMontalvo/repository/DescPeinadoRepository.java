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

    Optional<DescPeinado> findByNombrepeinado(String nombrepeinado);

    List<DescPeinado> findByNombrepeinadoContainingIgnoreCase(String filtro);

    //JPQL
    @Query("SELECT d FROM DescPeinado d WHERE d.nombrepeinado LIKE %:filtro%")
    List<DescPeinado> filtrarDescPeinadoPorNombre(@Param("filtro") String filtro);

    //SQL
    @Query(value = "SELECT * FROM descpeinado WHERE nombrepeinado LIKE %:filtro%",
            nativeQuery = true)
    List<DescPeinado> filtrarDescPeinadoPorNombreSQL(@Param("filtro") String filtro);





}