package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo.MedOrderRepo;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Encounter;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.MedOrder;

@Repository
public class MedOrderdao {

	@Autowired
	private MedOrderRepo medOrderRepo;

	@Autowired
	private Encounterdao encounterdao;

	public MedOrder saveMedorder(int eid, MedOrder medOrder) {

		Encounter encounter = encounterdao.getEncounter(eid);

		medOrder.setEncounter(encounter);
		return medOrderRepo.save(medOrder);
	}

	public MedOrder updateMedOrder(int id, MedOrder medOrder) {
		if (medOrderRepo.findById(id).isPresent()) {
			medOrder.setM_id(id);
			return medOrderRepo.save(medOrder);
		}
		{
			return null;
		}

	}

	public MedOrder getMedOder(int id) {
		if (medOrderRepo.findById(id).isPresent()) {
			MedOrder medOrder = medOrderRepo.findById(id).get();
			return medOrder;
		} else {
			return null;
		}
	}

	public MedOrder deleteMedOrder(int id) {
		if (medOrderRepo.findById(id).isPresent()) {
			MedOrder medOrder = medOrderRepo.findById(id).get();
			medOrderRepo.deleteById(id);
			return medOrder;
		} else {
			return null;
		}
	}

}
