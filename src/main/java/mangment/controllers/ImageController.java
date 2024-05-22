package mangment.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import mangment.entities.Hotel;
import mangment.entities.ImageModel;
import mangment.repository.ImageRepository;
import mangment.services.HotelService;



@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private HotelService hotelService;

   // @PostMapping("/upload/{hotelId}")
    //public ResponseEntity<String> uploadImage(@RequestParam("file") List<MultipartFile> files, @PathVariable Long hotelId) {
      //  try {
        //	Hotel hotel = hotelService.findById(hotelId);
        	//List<Long> ids = new ArrayList<>();
        	//for (MultipartFile file : files) {
        		// ImageModel image = new ImageModel();
                 //image.setImage(file.getBytes()); // Stockage de l'image sous forme de tableau d'octets
                 //ImageModel result = imageRepository.save(image);
                 //ids.add(result.getId());
			//}
        	//save list of ids in hotel table 
        	//hotel.setIdImages(ids);
        	//hotelService.saveHotel(hotel);
            //return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully.");
        //} catch (IOException e) {
          //  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        //}
   // }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<ImageModel> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            ImageModel image = imageOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Définir le type de contenu de la réponse
            return new ResponseEntity<>(image.getImage(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}