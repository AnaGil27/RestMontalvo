package cibertec.edu.pe.RestMontalvo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import cibertec.edu.pe.RestMontalvo.model.bd.DescMaquillaje;

import java.util.List;
import java.util.Optional;

@Repository
public interface DescMaquillajeRepository extends JpaRepository<DescMaquillaje,Integer>{
    Optional<DescMaquillaje> findBydesc_maquillaje(String desc_maquillaje);

    List<DescMaquillaje> findBydesc_maquillajeContainingIgnoreCase(String filtro);

    @Query("SELECT d FROM DescMaquillaje d WHERE d.desc_maquillaje LIKE %:filtro%")
    List<DescMaquillaje> filtrarDescMaquillajePorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM descmaquillaje WHERE desc_maquillaje LIKE %:filtro%",
            nativeQuery = true)
    List<DescMaquillaje> filtrarDescMaquillajePorNombreSQL(@Param("filtro") String filtro);




}
