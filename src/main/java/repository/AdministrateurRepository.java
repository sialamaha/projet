package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

}
