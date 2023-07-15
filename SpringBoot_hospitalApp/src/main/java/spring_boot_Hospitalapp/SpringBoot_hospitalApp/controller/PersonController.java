package spring_boot_Hospitalapp.SpringBoot_hospitalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.PersonService;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Person;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person)
	
	{
		return personService.savePerson(person);
		
	}
	
	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>>  updatePerson(@RequestParam int id , @RequestBody Person person)
	{
		return personService.updatePerson(id ,person);
	}

	
	public ResponseEntity<ResponseStructure<Person>> getperson(@PathVariable int id)
	
	{
		return personService.getpersonByid(id);
		
	}
}
