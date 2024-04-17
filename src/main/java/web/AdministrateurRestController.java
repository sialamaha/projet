package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Conducteur;
import services.AdministrateurService;

@RestController
@RequestMapping("/administrateurs")
public class AdministrateurRestController {
	
	 @Autowired
	    private AdministrateurService administrateurService;

	    @PostMapping("/conducteurs")
	    public ResponseEntity<String> ajouterConducteur(@PathVariable Long administrateurId, @RequestBody Conducteur conducteur) {
	        administrateurService.ajouterConducteur(administrateurId, conducteur);
	        return new ResponseEntity<>("Conducteur ajouté avec succès", HttpStatus.CREATED);
	    }

	    @PutMapping("/conducteurs/{id}")
	    public ResponseEntity<String> modifierConducteur(@PathVariable Long administrateurId, @PathVariable Long conducteurId, @RequestBody Conducteur conducteurModifie) {
	        administrateurService.modifierConducteur(administrateurId, conducteurId, conducteurModifie);
	        return new ResponseEntity<>("Conducteur modifié avec succès", HttpStatus.OK);
	    }

	    @DeleteMapping("/conducteurs/{id}")
	    public ResponseEntity<String> supprimerConducteur(@PathVariable Long administrateurId, @PathVariable Long conducteurId) {
	        administrateurService.supprimerConducteur(administrateurId, conducteurId);
	        return new ResponseEntity<>("Conducteur supprimé avec succès", HttpStatus.OK);
	    }

}
