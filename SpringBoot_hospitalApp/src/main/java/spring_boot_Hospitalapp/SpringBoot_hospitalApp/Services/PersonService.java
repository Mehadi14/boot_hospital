package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundForPersonException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Persondao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Person;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@Service
public class PersonService {
	
	@Autowired
	private Persondao persondao;
	
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person)
	{
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		Person daopPerson=persondao.savePerson(person);
		structure.setMessage("successfully saved person");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(daopPerson);
		
		
		return new ResponseEntity<ResponseStructure<Person>>(structure , HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id , Person person)
	{
		
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
	
		Person daoPerson=persondao.updateperson(id, person);
		if(daoPerson!=null)
		{
			structure.setMessage("successfully Upadted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoPerson);
			
			return new ResponseEntity<ResponseStructure<Person>>(structure , HttpStatus.OK);
		}else
			
		throw new IdNotFoundForPersonException();
	}

	public ResponseEntity<ResponseStructure<Person>> getpersonByid(int id) {
	
		return null;
	}

	

}
