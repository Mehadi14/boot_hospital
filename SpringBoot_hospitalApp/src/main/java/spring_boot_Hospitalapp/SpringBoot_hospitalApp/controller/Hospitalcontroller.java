package spring_boot_Hospitalapp.SpringBoot_hospitalApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.HospitalServices;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Hospital;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;
@RestController
public class Hospitalcontroller {

	@Autowired
	private HospitalServices hospitalServices;

	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalServices.saveHospital(hospital);

	}

	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,
			@RequestBody Hospital hospital) {
		return hospitalServices.updateHospital(id, hospital);
	}

	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id) {
		return hospitalServices.deleteHospital(id);
	}

	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@RequestParam int id) {
		return hospitalServices.getHospitalById(id);
	}

}
