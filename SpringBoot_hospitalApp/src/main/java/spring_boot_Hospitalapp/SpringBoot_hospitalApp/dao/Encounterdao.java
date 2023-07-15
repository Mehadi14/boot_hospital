package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo.EncounterRepo;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Encounter;

@Repository
public class Encounterdao {

	@Autowired
	private EncounterRepo encounterRepo;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}

	public Encounter updateEncounter(int eid, Encounter encounter) {
		if (encounterRepo.findById(eid).isPresent()) {
			encounter.setId(eid);
			return encounterRepo.save(encounter);
		} else {
			return null;
		}
	}

	public Encounter getEncounter(int eid) {
		if (encounterRepo.findById(eid).isPresent()) {
		return encounterRepo.findById(eid).get();
	}
		else
		return null;
	}
	
	
	public Encounter deleteEncounter(int id)
	{
		if(encounterRepo.findById(id).isPresent()) {
			Encounter daoEncounter=encounterRepo.findById(id).get();
		
		 encounterRepo.deleteById(id);
		 return daoEncounter;
	}else
	{
		throw new IdNotFoundException();
	}
		
	}
	
	public List<Encounter> findByEncountercost(long cost)
	{
		return encounterRepo.findByEncountercost(cost);
	}
	
	
}