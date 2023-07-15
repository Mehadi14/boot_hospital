package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer> {
	
	@Query("select b from Encounter b where b.cost<?1")
	public List<Encounter> findByEncountercost(long cost);

}
