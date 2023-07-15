package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Encounterdao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.MedOrderdao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Encounter;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.MedOrder;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@Service
public class MedOrderServices {

	@Autowired
	private MedOrderdao medOrderdao;
	
	@Autowired
	private Encounterdao encounterdao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(int eid, MedOrder medOrder) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		MedOrder mOrder = medOrderdao.saveMedorder(eid, medOrder);

		structure.setMessage("successfully saved:");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(mOrder);

		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id , MedOrder medOrder){
		
		MedOrder dbMedOrder=medOrderdao.getMedOder(id);
		medOrder.setEncounter(dbMedOrder.getEncounter());
		
		MedOrder medOrder2=medOrderdao.updateMedOrder(id, medOrder);
		if(medOrder2!=null)
		{	ResponseStructure<MedOrder> structure = new ResponseStructure<>();


		structure.setMessage("updated....:");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(medOrder2);

		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		}else
		return  null ;
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedorder(int id){
		MedOrder medOrder=medOrderdao.getMedOder(id);
		if(medOrder!=null)
		{ResponseStructure<MedOrder> structure = new ResponseStructure<>();


		structure.setMessage("fetched data");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(medOrder);

		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
			
		}else
		{
			  throw new IdNotFoundException("id not found for medorder") ;
		}
	}

	
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedorder(int id)
	{
		MedOrder medOrder1=medOrderdao.deleteMedOrder(id);
		if(medOrder1!=null)
		{
			ResponseStructure<MedOrder> structure = new ResponseStructure<>();


			structure.setMessage("deleted..");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrder1);

			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);	
		}else
		{
			return null;
		}
	}
}
