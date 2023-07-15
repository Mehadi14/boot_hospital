package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo.MeditemRepo;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.MedOrder;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Meditems;

@Repository
public class Meditemdao {

	@Autowired
	private MeditemRepo meditemRepo;

	@Autowired
	private MedOrderdao medOrderdao;

	public Meditems saveMeditems(Meditems meditems, int mid) {
		MedOrder medOrder = medOrderdao.getMedOder(mid);
		meditems.setMedOrder(medOrder);

		return meditemRepo.save(meditems);

	}

	public Meditems updateMeditems(int id, Meditems meditems) {
		return meditemRepo.save(meditems);
	}

	public Meditems getMeditemById(int id) {

		if (meditemRepo.findById(id).isPresent())
			;
		{
			Meditems meditems = meditemRepo.findById(id).get();
			return meditems;

		}

	}

	public Meditems deleteMeditems(int id) {
		if (meditemRepo.findById(id).isPresent()) {
			Meditems meditems = meditemRepo.findById(id).get();

			meditemRepo.deleteById(id);

			return meditems;
		} else {
			throw new IdNotFoundException();
		}
	}

}
