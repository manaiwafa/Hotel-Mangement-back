package mangment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mangment.entities.Hotel;

@Service
public interface HotelService {
  List<Hotel> findByActiveTrue();

  List<Hotel> findByActiveFalse();

  long countActiveHotels(boolean isActive);

  Hotel saveHotel(Hotel hotel);

  List<String> findAllVilles();

  List<Hotel> findByEmplacementVille(String emplacementVille);

  Hotel activateHotel(Long hotelId);
  Hotel findById(Long hotelId);


Hotel update(long idHotel, double prixAllInclusif, double prixDemiPension, double prixPensionComplete,
		double prixPetitDej, double PrixPersonne, double typeDouble, double typeSuite, double typeTriple,
		double typeSingle);




}
