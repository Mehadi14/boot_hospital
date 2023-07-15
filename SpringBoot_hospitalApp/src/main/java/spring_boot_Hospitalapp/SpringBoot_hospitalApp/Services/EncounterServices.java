package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundForEncounter;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Branchdao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Encounterdao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Persondao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Address;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Branch;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Encounter;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Person;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@Service
public class EncounterServices {
	@Autowired
	private Persondao persondao;
	@Autowired
	private Encounterdao encounterdao;
	@Autowired
	private Branchdao branchdao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person daoperson = persondao.getPersonById(pid);

		Branch daobranch = branchdao.getBranch(bid);
		List<Branch> branchs = new ArrayList<>();
		branchs.add(daobranch);
		encounter.setPerson(daoperson);
		encounter.setList(branchs);

		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		structure.setMessage("savedd");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(encounterdao.saveEncounter(encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Encounter>> upadteEncounter(int eid, Encounter encounter, int bid) {
		Encounter daoEncounter = encounterdao.getEncounter(eid);

		Branch branch = branchdao.getBranch(bid);

		List<Branch> list = daoEncounter.getList();
		list.add(branch);
		encounter.setList(list);
		encounter.setPerson(daoEncounter.getPerson());

		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		structure.setMessage("upadted");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(encounterdao.updateEncounter(eid, daoEncounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Encounter>> deletEncounter(int eid) {
		Encounter daoEncounter = encounterdao.deleteEncounter(eid);
		if (daoEncounter != null) {
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoEncounter);

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(int eid) {
		Encounter daoeEncounter=encounterdao.getEncounter(eid);
		if (daoeEncounter != null) {
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Successfully fetched....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoeEncounter);

		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);

		}
		else
		{
			throw new IdNotFoundForEncounter();
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Encounter>>> findByEncountercost(long cost)
	{
		 ResponseStructure<List<Encounter>> structure=new ResponseStructure<>();
		 structure.setData(encounterdao.findByEncountercost(cost));
		 structure.setStatus(HttpStatus.OK.value());
		return new  ResponseEntity<ResponseStructure<List<Encounter>>>(structure, HttpStatus.OK) ;
		
	}
}
	
