package mangment.controllers;

import mangment.entities.Hotel;
import mangment.entities.Utilisateur;
import mangment.model.AutentificationRequest;
import mangment.model.InscriptionRequest;
import mangment.repository.HotelRepository;
import mangment.repository.UtilisateurRepository;
import mangment.services.InscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateurs")
public class InscriptionController {

  private final HotelRepository hotelRepository;


  private final UtilisateurRepository utilisateurRepository;


  private final InscriptionService inscriptionService;

  public InscriptionController(HotelRepository hotelRepository,
                               UtilisateurRepository utilisateurRepository,
                               InscriptionService inscriptionService) {
    this.hotelRepository = hotelRepository;
    this.utilisateurRepository = utilisateurRepository;
    this.inscriptionService = inscriptionService;
  }

  @PostMapping("/inscription")
  public InscriptionRequest submitInscriptionForm(@RequestBody InscriptionRequest inscriptionDTO) {
    Hotel hotel = hotelRepository.save(inscriptionDTO.getHotel());
    Utilisateur utilisateur = inscriptionDTO.getUtilisateur();
    utilisateur.setHotel(hotel);
    utilisateurRepository.save(utilisateur);
    return inscriptionDTO;
  }

  @PostMapping("/logiin")
  public ResponseEntity<Utilisateur> connecterUtilisateur(
      @RequestBody AutentificationRequest autentificationRequest) {
    String email = autentificationRequest.getEmail();
    String motDePasse = autentificationRequest.getPassword();
    String codeHotel = autentificationRequest.getCodeHotel();
    Utilisateur utilisateur =
        inscriptionService.findByEmailAndMotdepasse(email, motDePasse, codeHotel)
            .orElseThrow(() -> new RuntimeException("veuillez verifier vos cordonner"));

    return new ResponseEntity<>(utilisateur, HttpStatus.OK);
  }
  @PostMapping("/login")
  public ResponseEntity<Utilisateur> connecterUtiilisateur(
      @RequestBody AutentificationRequest autentificationRequest) {
      String email = autentificationRequest.getEmail();
      String motDePasse = autentificationRequest.getPassword();
      String codeHotel = autentificationRequest.getCodeHotel();
      Utilisateur utilisateur;

      if (codeHotel != null) {
          utilisateur = inscriptionService.findByEmailAndMotdepasse(email, motDePasse, codeHotel)
                  .orElseThrow(() -> new RuntimeException("Veuillez vérifier vos coordonnées"));
      } else {
          utilisateur = inscriptionService.findAdminByEmailAndMotdepasseAndRoleNotNull(email, motDePasse)
                  .orElseThrow(() -> new RuntimeException("Veuillez vérifier vos coordonnées"));
      }
     

      return new ResponseEntity<>(utilisateur, HttpStatus.OK);
  }

 

}
    


