package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long>  {

}
