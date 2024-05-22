package mangment.services;

import java.util.Optional;

import mangment.entities.Hotel;
import mangment.entities.Utilisateur;

public interface InscriptionService {
   Utilisateur inscrire(Utilisateur utilisateur, Hotel hotel);
   Optional<Utilisateur> findByEmailAndMotdepasse(String email, String motdepasse, String codeHotel);
Optional<Utilisateur> findAdminByEmailAndMotdepasseAndRoleNotNull(String email, String motdepasse );

   
}
