package com.tms.rpa.controller;

import java.util.List;
import java.util.Optional;

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

import com.tms.rpa.models.ParameterData;
import com.tms.rpa.repository.ParameterRepo;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ParameterController {
	
	 @Autowired
	 ParameterRepo parameterRepo;
	 
	    @GetMapping("/parameters")
		public List<ParameterData> getParameters() {
			return parameterRepo.findAll();
		}
	    
	    @GetMapping("/Singleparameter")
	    public ParameterData getParameters1() {
	    List<ParameterData> h=parameterRepo.findAll();
	    return h.get(0);
	    }

		@GetMapping("/parameters/{id}")
		public Optional<ParameterData> getParameters(@PathVariable Integer id) {
			return parameterRepo.findById(id);
		}

		@DeleteMapping("/parameters/{id}")
		public boolean deleteParameters(@PathVariable Integer id) {
			parameterRepo.deleteById(id);
			return true;
		}

		@PutMapping("/parameters/{id}")
		public ResponseEntity<ParameterData> updateParameter(@PathVariable("id") int id,
				@RequestBody ParameterData data) {
			Optional<ParameterData> paraData = parameterRepo.findById(id);

			if (paraData.isPresent()) {
				ParameterData p1 = paraData.get();
				p1.setCube(data.getCube());
				p1.setWeight(data.getWeight());
				p1.setLinearfeet(data.getLinearfeet());
				p1.setSkid(data.getSkid());
				p1.setCubeper(data.getCubeper());
				p1.setWeightper(data.getWeightper());
				p1.setLinearfeetper(data.getLinearfeetper());
				p1.setSkidper(data.getSkidper());
				p1.setHeight(data.getHeight());
				p1.setWidth(data.getWidth());
				p1.setLength(data.getLength());
				p1.setSku(data.getSku());

				return new ResponseEntity<>(parameterRepo.save(p1), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}


		@PostMapping("/parameters")
		public ParameterData createParameters(@RequestBody ParameterData data) {
			return parameterRepo.save(data);
		}

}