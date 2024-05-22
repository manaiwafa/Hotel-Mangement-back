package mangment.services.impl;

import mangment.repository.ReservationRepository;

public class ResevationRequestServiceImpl {
	private ReservationRepository ReservationRepository;

	  public  ResevationRequestServiceImpl(ReservationRepository reservationRepository) {
	    this.ReservationRepository = reservationRepository;
	  }

	
}
