package spring_boot_Hospitalapp.SpringBoot_hospitalApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.EncounterServices;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Encounter;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@RestController
public class EncounterController {

	@Autowired
	private EncounterServices encounterServices;

	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,
			@RequestParam int pid, @RequestParam int bid) {
		return encounterServices.saveEncounter(encounter, pid, bid);
	}

	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestParam int eid,
			@RequestBody Encounter encounter, @RequestParam int bid) {
		return encounterServices.upadteEncounter(eid, encounter, bid);

	}
	
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteUpdate(@RequestParam int eid){
		return encounterServices.deletEncounter(eid);
		
	}
	
	
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(@RequestParam int eid)
	
	{
		return encounterServices.getEncounter(eid);
		
	}
	
	@GetMapping("/getcost/{cost}")
	public ResponseEntity<ResponseStructure<List<Encounter>>> findByEncountercost(@PathVariable long cost)
	{
		return encounterServices.findByEncountercost(cost);
		
	}
	
	
}
