package org.rpa.rpaui.controllers;

import java.util.List;
import java.util.Optional;

import org.rpa.rpaui.models.AccuracyData;
import org.rpa.rpaui.repo.AccuracyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccuracyController {
	
	
	@Autowired
	private AccuracyRepo accuracyRepo;
	
	@GetMapping("/accuracy")
	public List<AccuracyData> getAccuracy() {
		return accuracyRepo.findAll();
	}

	@GetMapping("/accuracy/{id}")
	public Optional<AccuracyData> getAccuracy(@PathVariable Integer id) {
		return accuracyRepo.findById(id);
	}

	@DeleteMapping("/accuracy/{id}")
	public boolean deleteAccuracy(@PathVariable Integer id) {
		accuracyRepo.deleteById(id);
		return true;
	}

	@PutMapping("/accuracy/{id}")
	public ResponseEntity<AccuracyData> updateAccuracy(@PathVariable("id") int id,
			@RequestBody AccuracyData data) {
		Optional<AccuracyData> accData = accuracyRepo.findById(id);

		if (accData.isPresent()) {
			AccuracyData a1 = accData.get();
			a1.setNonratio(data.getNonratio());
			a1.setNonweight(data.getNonweight());
			a1.setNoncube(data.getNoncube());
			a1.setPweight(data.getPweight());
			a1.setPratio(data.getCratio());
			a1.setCratio(data.getCratio());
			a1.setWratio(data.getWratio());

			return new ResponseEntity<>(accuracyRepo.save(a1), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@PostMapping("/accuracy")
	public AccuracyData createAccuracy(@RequestBody AccuracyData data) {
		return accuracyRepo.save(data);
	}


}
