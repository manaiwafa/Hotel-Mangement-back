package mangment.services.impl;

import com.mysql.cj.jdbc.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

//@Entity
public class ImageEntity {
        @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Lob
	    private Blob image1;
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Blob getImage1() {
			return image1;
		}
		public void setImage1(Blob image1) {
			this.image1 = image1;
		}
		public Blob getImage2() {
			return image2;
		}
		public void setImage2(Blob image2) {
			this.image2 = image2;
		}
		public Blob getImage3() {
			return image3;
		}
		public void setImage3(Blob image3) {
			this.image3 = image3;
		}
		public Blob getImage4() {
			return image4;
		}
		public void setImage4(Blob image4) {
			this.image4 = image4;
		}
		public Blob getImage5() {
			return image5;
		}
		public void setImage5(Blob image5) {
			this.image5 = image5;
		}
		@Lob
	    private Blob image2;
	    @Lob
	    private Blob image3;
	    @Lob
	    private Blob image4;
	    @Lob
	    private Blob image5;
	    
}