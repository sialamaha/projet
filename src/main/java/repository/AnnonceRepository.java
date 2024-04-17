package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

}
