package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo.PersonRepo;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Person;

@Repository
public class Persondao {
	
	@Autowired
	private PersonRepo personRepo;
	
	
	public Person savePerson(Person person)
	{
		return personRepo.save(person);
		
	}
	
	public Person updateperson(int id , Person person)
	{
		if(personRepo.findById(id).isPresent())
		{
			person.setId(id);
			
			return personRepo.save(person);
		}
		return null;
		
	}
	
	public Person getPersonById(int id)
	{
		if(personRepo.findById(id).isPresent())
		{
			return personRepo.findById(id).get();
		}
		else
		{
			   throw new IdNotFoundException();
		}
	}
	
	public Person deleteById(int id)
	{
		if(personRepo.findById(id).isPresent())
		{
			Person person=personRepo.findById(id).get();
			
	      personRepo.deleteById(id);
	       return person;
		}
		else
		{
			throw new IdNotFoundException();	
		}
	
		
	}
	
	
	

}
