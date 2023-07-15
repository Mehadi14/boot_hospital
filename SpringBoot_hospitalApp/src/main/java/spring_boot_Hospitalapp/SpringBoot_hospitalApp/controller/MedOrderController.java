package spring_boot_Hospitalapp.SpringBoot_hospitalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.MedOrderServices;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.MedOrder;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@RestController
public class MedOrderController {
	
	@Autowired
	private MedOrderServices medOrderServices;

	@PostMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestParam int eid ,@RequestBody MedOrder medOrder)
	{
		return medOrderServices.saveMedOrder(eid, medOrder);
		
	}
	
	
	@PutMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id , @RequestBody MedOrder medOrder){
		return medOrderServices.updateMedOrder(id, medOrder);
		
	}

	@DeleteMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> deletemedorder(@RequestParam int id){
		return medOrderServices.deleteMedorder(id);
		
	}
	
	@GetMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedorder(@RequestParam int id){
		return medOrderServices.getMedorder(id);
		
	}
	
	
}
