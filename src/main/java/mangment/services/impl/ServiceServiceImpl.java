package mangment.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import mangment.entities.Services;
import mangment.repository.ServiceRepository;
import mangment.services.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{

	 private  ServiceRepository serviceRepository;
		  public ServiceServiceImpl (ServiceRepository serviceRepository) {
		    this.serviceRepository = serviceRepository;
		  }
	@Override
	public List<Services> findByHotelId(Long hotelId) {
		// TODO Auto-generated method stub
		return  serviceRepository .findByHotelId(hotelId);				
	}
	
	@Override
	public List<Services> findAll() {
		// TODO Auto-generated method stub
		return  serviceRepository .findAll();				
	}
	 @Override
	  public void deleteService(Long id) {
	    serviceRepository.deleteById(id);
	  }
	}
