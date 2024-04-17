package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Administrateur;
import entities.Conducteur;
import repository.AdministrateurRepository;
import repository.ConducteurRepository;
public class AdministrateurService {
	@Autowired
    private AdministrateurRepository administrateurRepository;

    public void ajouterConducteur(Long administrateurId, Conducteur conducteur) {
        Administrateur administrateur = administrateurRepository.findById(administrateurId).orElseThrow(() -> new RuntimeException("Administrateur non trouvé"));
        administrateur.ajouterConducteur(conducteur);
        administrateurRepository.save(administrateur);
    }

    public void modifierConducteur(Long administrateurId, Long conducteurId, Conducteur conducteurModifie) {
        Administrateur administrateur = administrateurRepository.findById(administrateurId).orElseThrow(() -> new RuntimeException("Administrateur non trouvé"));
        administrateur.modifierConducteur(conducteurId, conducteurModifie);
        administrateurRepository.save(administrateur);
    }

    public void supprimerConducteur(Long administrateurId, Long conducteurId) {
        Administrateur administrateur = administrateurRepository.findById(administrateurId).orElseThrow(() -> new RuntimeException("Administrateur non trouvé"));
        administrateur.supprimerConducteur(conducteurId);
        administrateurRepository.save(administrateur);
    }

}
