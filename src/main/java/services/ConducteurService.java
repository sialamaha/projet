package services;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Annonce;
import entities.Conducteur;
import repository.ConducteurRepository;

public class ConducteurService {
	@Autowired
    private ConducteurRepository conducteurRepository;

    // Méthode pour créer une annonce pour un conducteur
    public void creerAnnonce(Long conducteurId, Annonce annonce) {
        Conducteur conducteur = conducteurRepository.findById(conducteurId)
            .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));
        conducteur.creerAnnonce(annonce);
        conducteurRepository.save(conducteur);
    }

    // Méthode pour consulter les annonces associées à un conducteur
    public void consulterAnnonces(Long conducteurId) {
        Conducteur conducteur = conducteurRepository.findById(conducteurId)
            .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));
        conducteur.consulter();
    }

}
