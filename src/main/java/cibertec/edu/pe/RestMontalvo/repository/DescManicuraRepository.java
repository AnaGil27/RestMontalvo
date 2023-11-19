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
    Optional<DescManicura> findByDescManicura(String desc_manicura);

    List<DescManicura> findBydesc_manicuraContainingIgnoreCase(String filtro);

    @Query("SELECT d FROM DescManicura d WHERE d.desc_manicura LIKE %:filtro%")
    List<DescManicura> filtrardesc_manicura(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM DescManicura WHERE desc_manicura LIKE %:filtro%",
            nativeQuery = true)
    List<DescManicura> filtrardesc_manicuraPorNombreSQL(@Param("filtro") String filtro);

}
