package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
