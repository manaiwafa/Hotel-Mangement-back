package mangment.controllers;
import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mangment.entities.Magasin;
import mangment.entity.MagasinRequest;
import mangment.repository.MagasinRepository;
import mangment.services.impl.MagasinServiceImpl;

@RestController
@RequestMapping("/magasin")
public class MagasinController {

	private final MagasinRepository magasinRepository;
    private final  MagasinServiceImpl magasinServiceImpl;


	  public MagasinController(MagasinRepository magasinRepository,MagasinServiceImpl maasinServiceImpl ) {
	    this.magasinRepository = magasinRepository;
	    this.magasinServiceImpl= maasinServiceImpl;
	  }
	  
	  @PostMapping("/")
	  public Magasin addMagasin(@RequestBody Magasin magasin) {
		    return magasinRepository.save (magasin);
		  }
	
	  @GetMapping("/{hotelId}")
	  public Magasin findMagasin(@PathVariable Long hotelId) {
		    return magasinServiceImpl.findMagasinByHotelId (hotelId);
		  }
	  @PostMapping("/updateStock/{hotelId}")
	    public Magasin updateStock(@PathVariable Long hotelId) {
		  LocalDate date = LocalDate.now();
	       
	        return  magasinServiceImpl.mettreAJourStockMagasin(hotelId, date);
	    }	
	  @PostMapping("/{idHotel}/add")
	    public ResponseEntity<Magasin> ajouterStockMagasin(@PathVariable Long idHotel, @RequestBody MagasinRequest magasinRequest) {
	        Magasin magasinMisAJour = magasinServiceImpl.Ajouter(idHotel, magasinRequest);

	        return ResponseEntity.ok().body(magasinMisAJour);
	    }
	}
