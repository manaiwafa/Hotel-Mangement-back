package mangment.services.impl;

import java.util.Optional;
import mangment.repository.UtilisateurRepository;
import mangment.entities.Hotel;
import mangment.entities.Utilisateur;
import mangment.services.InscriptionService;
import org.springframework.stereotype.Service;

@Service
public class InscriptionServiceImpl implements InscriptionService {

  private final UtilisateurRepository utilisateurRepository;

  public InscriptionServiceImpl(UtilisateurRepository utilisateurRepository) {
    this.utilisateurRepository = utilisateurRepository;
  }

  @Override
  public Utilisateur inscrire(Utilisateur utilisateur, Hotel hotel) {

    return null;
  }

  @Override
  public Optional<Utilisateur> findByEmailAndMotdepasse(String email, String motdepasse,
                                                        String codeHotel) {
    return utilisateurRepository.findUtilisateurByEmailAndMotDePasseAndHotelNom(email, motdepasse,
        codeHotel);
  }
  @Override
  public Optional<Utilisateur> findAdminByEmailAndMotdepasseAndRoleNotNull(String email, String motdepasse) {
    return utilisateurRepository.findUtilisateurByEmailAndMotDePasseAndRoleIsNotNull(email, motdepasse);
  }


}
