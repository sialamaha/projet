package entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Getter
@Setter
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;
    
    private String adresseEmail;

    private String numeroTelephone;

    private String motsPasse;

    private String photo;

    private String genre;

    private String avis;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseEmail() {
		return adresseEmail;
	}

	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	@OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<Annonce> annonces;
    
    @ManyToOne
    private Administrateur administrateur;
    
    public void creerAnnonce(Annonce annonce) {
        annonces.add(annonce);
    }

    
    public void consulter() {
    	System.out.println("Annonces associées au conducteur " + nom + " " + prenom + ":");
        for (Annonce annonce : annonces) {
            System.out.println(annonce);
        }
    }

}


