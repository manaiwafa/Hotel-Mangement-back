package mangment.controllers;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mangment.entities.Services;
import mangment.repository.ServiceRepository;
import mangment.services.impl.ServiceServiceImpl;


@RestController
@RequestMapping("/services")

public class ServiceController {
	
	 private  ServiceRepository serviceRepository;
	  private  ServiceServiceImpl serviceServiceImp;
		  public ServiceController (ServiceRepository serviceRepository, ServiceServiceImpl ServiceServiceImp ) {
		    this.serviceRepository = serviceRepository;
		    this.serviceServiceImp = ServiceServiceImp;
		  }

		  @PostMapping
		  public Services addService(@RequestBody Services service) {
		    return serviceRepository.save(service);
		  }
		  @GetMapping("/find/{hotelId}")
		  public List<Services> findAllService(@PathVariable long hotelId ) {
				return  serviceServiceImp.findByHotelId(hotelId);
			}
		  @GetMapping("/find")
		  public List<Services> findAllService() {
				return  serviceServiceImp.findAll();
			}

		  @DeleteMapping("/delete/{id}")
			public ResponseEntity<String> deleteChambre(@PathVariable Long id) {
			  serviceServiceImp.deleteService(id);
				return ResponseEntity.ok(" été supprimée avec succès");
			}

}
