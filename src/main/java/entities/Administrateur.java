package entities;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Administrateur {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String adresseEmail;

    private String motsPasse;
    
    @OneToMany(mappedBy = "administrateur")
    private List<Conducteur> conducteurs;
    
    public void ajouterConducteur(Conducteur conducteur) {
        conducteurs.add(conducteur);
    }

    public void modifierConducteur(Long id, Conducteur conducteurModifie) {
    	for (Conducteur conducteur : conducteurs) {
            if (conducteur.getId().equals(conducteurModifie.getId())) {
                conducteur.setNom(conducteurModifie.getNom());
                conducteur.setPrenom(conducteurModifie.getPrenom());
                conducteur.setAdresseEmail(conducteurModifie.getAdresseEmail());
                conducteur.setNumeroTelephone(conducteurModifie.getNumeroTelephone());
                // Ajoutez d'autres attributs à modifier si nécessaire
                break;
            }
        }
    }

    public void supprimerConducteur(Long id) {
        conducteurs.removeIf(conducteur -> conducteur.getId().equals(id));
    }
    

}