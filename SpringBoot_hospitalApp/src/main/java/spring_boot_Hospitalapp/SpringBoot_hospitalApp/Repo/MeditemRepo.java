package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Meditems;

public interface MeditemRepo extends JpaRepository<Meditems, Integer> {

}
