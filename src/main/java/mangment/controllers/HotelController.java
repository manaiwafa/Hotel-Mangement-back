package mangment.controllers;


import java.util.List;
import java.util.Optional;

import mangment.entities.Hotel;
import mangment.model.SearchFilterDto;
import mangment.entities.ImageModel;
import mangment.repository.HotelRepository;
import mangment.services.HotelService;
import mangment.services.impl.HotelServiceImp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  private final HotelRepository hotelRepository;
  private final HotelService hotelServiceImp;

  public HotelController(HotelRepository hotelRepository, HotelServiceImp hotelServiceImp) {
    this.hotelRepository = hotelRepository;
    this.hotelServiceImp = hotelServiceImp;
  }


@PostMapping("/add")
public Hotel addHotel(@RequestBody Hotel hotel) {
	return hotelRepository.save(hotel);
}


  @GetMapping("/active")
  public List<Hotel> getHotelsByActive() {
    return hotelRepository.findByActiveTrue();
  }

  @GetMapping("/inactive")
  public List<Hotel> getHotelsByInActive() {
    return hotelRepository.findByActiveFalse();
  }

  @GetMapping("/count")
  public long countVerifiedHotels() {
    return hotelRepository.countByActive(true);
  }

  @GetMapping("/villes")
  public List<String> findAllVilles() {
    return hotelServiceImp.findAllVilles();
  }

  @GetMapping("/emplacementHotel/{emplacementVille}")
  public List<Hotel> findByEmplacement(@PathVariable String emplacementVille) {
    return hotelServiceImp.findByEmplacementVille(emplacementVille);
  }

  @PutMapping("/active/{hotelId}")
  public Hotel activateHotel(@PathVariable Long hotelId) {
    return hotelServiceImp.activateHotel(hotelId);
  }

  @PutMapping("/{hotelId}")
  public Hotel updateHotelPrices(@PathVariable long hotelId, @RequestBody Hotel request) {

    return hotelServiceImp.update(hotelId, request.getPrixAllInclusif(),
        request.getPrixDemiPension(),
        request.getPrixPensionComplete(), request.getPrixPetitDej(),
        request.getPrixPersonne(), request.getTypeDouble(),
        request.getTypeSuite(), request.getTypeTriple(), request.getTypleSingle());
  }

  @GetMapping("/{hotelId}/find")
  public Optional<Hotel> findById(@PathVariable Long hotelId) {
    return hotelRepository.findById(hotelId);
  }

  @PostMapping("/filter")
  public List<Hotel> findHotelByRegionAndDate(@RequestBody SearchFilterDto searchFilterDto) {
    return hotelRepository.findAvailableHotel(searchFilterDto.region(), searchFilterDto.dateArrive(), searchFilterDto.dateDepart());
  }

 
  
  
}
