package mangment.services;

import java.time.LocalDate;

import mangment.entities.Magasin;
import mangment.entity.MagasinRequest;

public interface MagasinService {
	 Magasin findMagasinByHotelId(Long hotelId);

	Magasin mettreAJourStockMagasin(Long idHotel, LocalDate date);


	Magasin Ajouter(Long idHotel, MagasinRequest magasinRequest);
}
