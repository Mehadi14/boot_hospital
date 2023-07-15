package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundForBranchException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Branchdao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Branch;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Hospital;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;
@Service
public class BranchServices {

	@Autowired
	private Branchdao branchdao;
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch , int hid , int aid)
	{
		ResponseStructure<Branch>  responseStructure=new ResponseStructure<Branch>();
		responseStructure.setMessage("succesfullly saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchdao.saveBranch(branch, hid, aid));
		
		return new ResponseEntity<ResponseStructure<Branch>> (responseStructure, HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int bid, int aid)
	{
       if(branchdao.saveBranch(branch, bid , aid )!=null) {
	
       
		ResponseStructure<Branch>  responseStructure=new ResponseStructure<Branch>();
		responseStructure.setMessage("succesuly updated saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchdao.saveBranch(branch, bid , aid ));
		return  new ResponseEntity<ResponseStructure<Branch>> (responseStructure, HttpStatus.CREATED);
       }else
       {
    	   throw new IdNotFoundException("id not found for the branch");
       }
	}
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> getBranch(int hid)
	{
		ResponseStructure<Branch> bStructure=new ResponseStructure<Branch>();
		Branch branch1=branchdao.getBranch(hid);
		if(branch1!=null)
		{
			bStructure.setMessage("successfylly found:");
			bStructure.setStatus(HttpStatus.OK.value());
			bStructure.setData(branch1);
			return new ResponseEntity<ResponseStructure<Branch>>(bStructure, HttpStatus.OK);
		}else
		{
			throw new IdNotFoundForBranchException("id not found for the branch");
		    
		}
		
		
			
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int bid)
	{
		ResponseStructure<Branch> bStructure=new ResponseStructure<Branch>();
		Branch branch1=branchdao.getBranch(bid);
		if(branch1!=null)
		{
			bStructure.setMessage("successfylly deleted:");
			bStructure.setStatus(HttpStatus.OK.value());
			bStructure.setData(branch1);
			return new ResponseEntity<ResponseStructure<Branch>>(bStructure, HttpStatus.OK);
		}else
		{
			
			throw new IdNotFoundForBranchException("id not found for the branch");
		    
		}
	
	}
	
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByhospital(int hid)
	{
		ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("fetcched");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(branchdao.getBranchByHospital(hid));
		return new ResponseEntity<ResponseStructure<List<Branch>> >(responseStructure , HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> findByManager(String manager)
	{
		ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<>();
		List<Branch> branch=branchdao.findByManager(manager);
		responseStructure.setData(branchdao.findByManager(manager));
		responseStructure.setMessage("all fetched based on manager");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure , HttpStatus.OK);
	}
	
}
