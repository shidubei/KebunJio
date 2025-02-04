package iss.nus.edu.sg.sa4106.KebunJio.Controllers;


import iss.nus.edu.sg.sa4106.KebunJio.Models.EdiblePlantSpecies;
import iss.nus.edu.sg.sa4106.KebunJio.Services.EdiblePlantSpeciesService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Species")
@CrossOrigin(origins = "*")
public class EdiblePlantSpeciesController {
	@Autowired
	private EdiblePlantSpeciesService ediblePlantSpeciesService;
	
	@GetMapping("/{speciesId}")
	public ResponseEntity<EdiblePlantSpecies> getSpecies(@PathVariable String speciesId) {
        try {
            Optional<EdiblePlantSpecies> existingSpecies = ediblePlantSpeciesService.getEdiblePlantSpecies(speciesId);
            if (existingSpecies.isPresent()) {
            	return ResponseEntity.ok(existingSpecies.get());
            } else {
            	return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
	}
	
	@GetMapping
	public ResponseEntity<List<EdiblePlantSpecies>> getAllSpecies() {
        try {
        	List<EdiblePlantSpecies> allSpecies = ediblePlantSpeciesService.getAllEdiblePlantSpecies();
            if (allSpecies.size() > 0) {
            	return ResponseEntity.ok(allSpecies);
            } else {
            	return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
	}
}
