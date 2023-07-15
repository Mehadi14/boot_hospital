package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
	
	public Hospital findByEmail(String email);

}
