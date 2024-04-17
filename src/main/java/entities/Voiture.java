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
public class Voiture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroSerie;

    private String Marque;

    private String couleur;

    private int nbrPlace;

    private String climatisation;
    
    private String Capacitebagage;
    @OneToMany(mappedBy = "voiture")
    private List<Annonce> annonces;

}
