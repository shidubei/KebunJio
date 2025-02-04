package iss.nus.edu.sg.sa4106.KebunJio.Services;


import iss.nus.edu.sg.sa4106.KebunJio.Models.EdiblePlantSpecies;
import iss.nus.edu.sg.sa4106.KebunJio.Repository.EdiblePlantSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EdiblePlantSpeciesService {
    @Autowired
    private EdiblePlantSpeciesRepository ediblePlantSpeciesRepo;

  	@Autowired
	  private EdiblePlantRepository ediblePlantSpeciesRepository;
  
    // get one species
    //public Optional<EdiblePlantSpecies> getEdiblePlantSpecies(String id) {
    //	return ediblePlantSpeciesRepo.findById(id);
    //}
    
    // get all species
    public List<EdiblePlantSpecies> getAllEdiblePlantSpecies() {
    	return ediblePlantSpeciesRepo.findAll();
    }
	
	public EdiblePlantSpecies getEdiblePlantSpeciesByEdiblePlantSpeciesId(String EdiblePlantSpeciesId) {
		Optional<EdiblePlantSpecies> ediblePlantSpecies = ediblePlantSpeciesRepository.findById(EdiblePlantSpeciesId);
		if(ediblePlantSpecies.isPresent()) {
			return ediblePlantSpecies.get();
		}else {
			return null;
		}
	}
	
    public EdiblePlantSpecies getEdiblePlantSpeciesByName(String name) {
        return ediblePlantSpeciesRepository.findByName(name);
    }

}
