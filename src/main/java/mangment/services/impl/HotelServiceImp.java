package mangment.services.impl;

import java.util.List;

import mangment.services.HotelService;
import org.springframework.stereotype.Service;

import mangment.repository.HotelRepository;
import mangment.entities.Hotel;

@Service
public class HotelServiceImp implements HotelService {

  private final HotelRepository hotelRepository;

  public HotelServiceImp(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @Override
  public List<Hotel> findByActiveTrue() {
    return hotelRepository.findByActiveTrue();
  }
 


  @Override
  public List<Hotel> findByActiveFalse() {
    return hotelRepository.findByActiveFalse();
  }


  @Override
  public long countActiveHotels(boolean isActive) {
    return hotelRepository.countByActive(isActive);
  }


  @Override
  public Hotel saveHotel(Hotel hotel) {
	  hotelRepository.save(hotel);
    return hotel;
  }

  @Override
  public List<String> findAllVilles() {
    return hotelRepository.findAllVilles();
  }

  @Override
  public List<Hotel> findByEmplacementVille(String emplacementVille) {
      return hotelRepository.findHotelByEmplacementVilleAndActiveIsTrue(emplacementVille);
  }

  @Override
  public Hotel activateHotel(Long hotelId) {
    Hotel hotel =  hotelRepository.findHotelById(hotelId);
    hotel.setActive(true);
    return hotelRepository.save(hotel);
  }

 
  @Override
  public Hotel update(long idHotel, double prixAllInclusif, double prixDemiPension, double prixPensionComplete,
		  double prixPetitDej,double PrixPersonne,double typeDouble,double typeSuite,double typeTriple,double typeSingle ) {
      Hotel hotel = hotelRepository.findHotelById(idHotel);
      if (hotel != null) {
          hotel.setPrixAllInclusif(prixAllInclusif);
          hotel.setPrixDemiPension(prixDemiPension);
          hotel.setPrixPensionComplete(prixPensionComplete);
          hotel.setPrixPetitDej(prixPetitDej);
          hotel.setPrixPersonne(PrixPersonne);
          hotel.setTypeDouble(typeDouble);
          hotel.setTypeSuite(typeSuite);
          hotel.setTypeTriple(typeTriple);
          hotel.setTypleSingle(typeSingle);
          
          return hotelRepository.save(hotel);
      } else {
          // Gérer le cas où l'hôtel n'est pas trouvé
          // Peut-être lancer une exception ou gérer de manière appropriée
          return null;
      }
  }

@Override
public Hotel findById(Long hotelId) {
	// TODO Auto-generated method stub
	return hotelRepository.findHotelById(hotelId);
}
}

	

