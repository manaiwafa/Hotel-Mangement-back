package mangment.controllers;

import java.util.List;
import mangment.entities.Utilisateur;
import mangment.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateurs")
public class UserController {

  private final UtilisateurRepository utilisateurRepository;

  public UserController(UtilisateurRepository utilisateurRepository) {
    this.utilisateurRepository = utilisateurRepository;
  }

  @GetMapping("")
  public ResponseEntity<List<Utilisateur>> findAll() {
    return new ResponseEntity<>(utilisateurRepository.findAll(), HttpStatus.OK);
  }

  @PutMapping("")
  public ResponseEntity<Utilisateur> updateUser(@RequestBody Utilisateur utilisateur) {
    return new ResponseEntity<>(utilisateurRepository.save(utilisateur), HttpStatus.OK);
  }

}
