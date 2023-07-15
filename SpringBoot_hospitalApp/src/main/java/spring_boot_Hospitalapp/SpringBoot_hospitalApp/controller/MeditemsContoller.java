package spring_boot_Hospitalapp.SpringBoot_hospitalApp.controller;

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

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.MeditemsServices;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Meditems;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@RestController
public class MeditemsContoller {
	
	@Autowired
	private MeditemsServices meditemsServices;
	
	@PostMapping("/meditems")
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditem(@RequestBody Meditems meditems ,@RequestParam int mid)
	{
		return meditemsServices.saveMeditems(meditems, mid);
		
	}
	
	@PutMapping("/meditems")
	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(@RequestParam int id, @RequestBody Meditems meditems){
		return meditemsServices.updateMeitems(id , meditems);
		
	}
	
	@GetMapping("/meditems")
	public ResponseEntity<ResponseStructure<Meditems>> getMeditems( @RequestParam int id){
		return meditemsServices.getMeditemById(id);
		
	}

	@DeleteMapping("/meditems")
	public ResponseEntity<ResponseStructure<Meditems>>  deleteMeditems(@RequestParam int id){
		return meditemsServices.deleteMeditems(id);
		
	}
}
