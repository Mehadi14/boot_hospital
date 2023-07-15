package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Branch;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Hospital;


public interface BranchRepo  extends JpaRepository<Branch, Integer> {

	@Query("select b from Branch b where b.hospital=?1 ")
	public List<Branch> findBranchBYhospital(Hospital hospital);
	
	
	
	public List<Branch> findByManager(String manager);
}
