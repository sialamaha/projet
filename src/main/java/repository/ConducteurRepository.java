package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Annonce;
import entities.Conducteur;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long>  {

	@Query("SELECT a FROM Annonce a WHERE a.conducteur.id = :conducteurId")
    List<Annonce> consulterAnnonces(@Param("conducteurId") Long conducteurId);
}
