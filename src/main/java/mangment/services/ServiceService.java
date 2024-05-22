package mangment.services;

import java.util.List;

import mangment.entities.Services;

public interface ServiceService {
	List<Services> findByHotelId(Long hotelId);

	void deleteService(Long id);

	List<Services> findAll();

}
