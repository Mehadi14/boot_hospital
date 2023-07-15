package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo.HospitalRepo;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Branch;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Hospital;

@Repository
public class Hospitaldao {

	@Autowired
	private HospitalRepo hospitalRepo;

	private Branchdao branchdao;
	public Hospital saveHospital(Hospital hospital)

	{
		return hospitalRepo.save(hospital);
	}

	public Hospital updaHospital(int id, Hospital hospital) {
		if (hospitalRepo.findById(id).isPresent()) {
			hospital.setId(id);
			return hospitalRepo.save(hospital);
		} else {
			return null;
		}
	}

	public Hospital deleteHospital(int id) {
		if (hospitalRepo.findById(id).isPresent()) {
			Hospital daoHospital = hospitalRepo.findById(id).get();
			hospitalRepo.delete(daoHospital);

			return daoHospital;
		} else {
			throw new IdNotFoundException();
		}
	}

	public Hospital getHospital(int id) {
		if (hospitalRepo.findById(id).isPresent()) {
			Hospital daoHospital = hospitalRepo.findById(id).get();

			return daoHospital;
		} else {
			throw new IdNotFoundException();
		}
	}

	public List<Hospital> getAlHospitals() {
		return hospitalRepo.findAll();

	}

	public Hospital getByEmail(String email) {
		return hospitalRepo.findByEmail(email);

	}
	
	
	
}
