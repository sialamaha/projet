package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Annonce;
import services.ConducteurService;

@RestController
@RequestMapping("/conducteurs")
public class ConducteurRestController {
	
	@Autowired
    private ConducteurService conducteurService;

    @PostMapping("/{conducteurId}/annonces")
    public ResponseEntity<String> creerAnnonce(@PathVariable Long conducteurId, @RequestBody Annonce annonce) {
        conducteurService.creerAnnonce(conducteurId, annonce);
        return new ResponseEntity<>("Annonce créée avec succès", HttpStatus.CREATED);
    }

    @GetMapping("/{conducteurId}/annonces")
    public ResponseEntity<String> consulterAnnonces(@PathVariable Long conducteurId) {
        conducteurService.consulterAnnonces(conducteurId);
        return new ResponseEntity<>("Consultation des annonces du conducteur réussie", HttpStatus.OK);
    }

}
