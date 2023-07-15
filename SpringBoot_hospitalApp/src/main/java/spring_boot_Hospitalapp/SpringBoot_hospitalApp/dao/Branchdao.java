package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo.BranchRepo;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Address;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Branch;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Hospital;

@Repository
public class Branchdao {

	@Autowired
	private BranchRepo branchRepo;
	@Autowired
	private Hospitaldao hospitaldao;

	@Autowired
	private Addressdao addressdao;
//
//	public <Addresss> Branch saveBranch(Branch branch, int hid, int aid)
	public  Branch saveBranch(Branch branch, int hid, int aid){
		Hospital hospital = hospitaldao.getHospital(hid);
		branch.setHospital(hospital);
		 Address addresss=addressdao.getAddressById(aid);
		 branch.setAddress(addresss);
		return branchRepo.save(branch);

	}

	public Branch updateSave(Branch branch, int bid) {

		if (branchRepo.findById(bid).isPresent()) {
			branch.setId(bid);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch getBranch(int bid) {
		if (branchRepo.findById(bid).isPresent()) {

			return branchRepo.findById(bid).get();
		} else {
			throw new IdNotFoundException("no id present");
		}
	}

	public Branch deleteBranch(int bid)

	{
		if (branchRepo.findById(bid).isPresent()) {
			
			Branch branch = branchRepo.findById(bid).get();
			branchRepo.delete(branch);
			return branch;
		} else {
			throw new IdNotFoundException();
		}
	}

	public List<Branch> getBranchByHospital(int hid) {
		Hospital hospital = hospitaldao.getHospital(hid);

		return branchRepo.findBranchBYhospital(hospital);
	}

	
	public List<Branch> findByManager(String manager)
	{
		List<Branch> branch=branchRepo.findByManager(manager);
		
		return branchRepo.findByManager(manager);
//		return branch;
		
	}
}
