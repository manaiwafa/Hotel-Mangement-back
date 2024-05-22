package mangment.controllers;

import java.util.List;
import mangment.entities.Region;
import mangment.repository.RegionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
public class RegionController {

  private final RegionRepository regionRepository;

  public RegionController(RegionRepository regionRepository) {
    this.regionRepository = regionRepository;
  }

  @GetMapping("")
  public List<Region> findAllRegion() {
    return regionRepository.findAll();
  }
}
