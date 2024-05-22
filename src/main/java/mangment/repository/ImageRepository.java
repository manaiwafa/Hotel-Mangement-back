package mangment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mangment.entities.ImageModel;

@Repository
public interface ImageRepository  extends JpaRepository <ImageModel,Long>{

	List<ImageModel> findByHotelId(Long hotelId);
	
}