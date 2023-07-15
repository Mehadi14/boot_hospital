package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Meditemdao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Meditems;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@Service
public class MeditemsServices {
	
	@Autowired
	private Meditemdao meditemdao;

	
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(Meditems meditems, int mid)
	{
		
		Meditems meditems2=meditemdao.saveMeditems(meditems, mid);
		ResponseStructure<Meditems> structure=new ResponseStructure<>();
		structure.setMessage("saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(meditems2);
		return new ResponseEntity<ResponseStructure<Meditems>>(structure , HttpStatus.OK);
		
	}


	public ResponseEntity<ResponseStructure<Meditems>> updateMeitems(int id, Meditems meditems) {
	
		Meditems meditems2=meditemdao.getMeditemById(id);
		meditems.setMedOrder(meditems2.getMedOrder());
		
		
		meditems.setId(id);
		Meditems meditems3=meditemdao.updateMeditems(id, meditems);
		if(meditems3!=null) {
		ResponseStructure<Meditems> structure=new ResponseStructure<>();
		structure.setMessage("items updatedd..");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(meditems2);
		return new ResponseEntity<ResponseStructure<Meditems>>(structure , HttpStatus.OK);
	}else
	{
		return null;
	}
}
	
	public ResponseEntity<ResponseStructure<Meditems>> getMeditemById(int id){
		Meditems meditems=meditemdao.getMeditemById(id);
		ResponseStructure<Meditems> structure=new ResponseStructure<>();
		if(meditems!=null )
		{
		structure.setMessage("items fetched..");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(meditems);
		
		return new ResponseEntity<ResponseStructure<Meditems>>(structure , HttpStatus.OK);
		}else
		{
//			structure.setMessage("not found item..");
//			structure.setStatus(HttpStatus.CREATED.value());
//			structure.setData(meditems);
//			return new ResponseEntity<ResponseStructure<Meditems>>(structure , HttpStatus.NOT_FOUND);
			
			return null;
		}
	}


	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(int id) {
		Meditems meditems=meditemdao.deleteMeditems(id);
		ResponseStructure<Meditems> structure=new ResponseStructure<>();
		if(meditems!=null)
		{     structure.setMessage("successfully delete");
		      structure.setStatus(HttpStatus.OK.value());
			
			structure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(structure , HttpStatus.OK);
		}else
		{
			structure.setMessage("not found item..");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(structure , HttpStatus.NOT_FOUND);
		}
		
	}
}
