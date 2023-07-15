package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Hospitaldao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Hospital;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@Service
public class HospitalServices {

	@Autowired
	private Hospitaldao hospitaldao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		Hospital hospital2= hospitaldao.saveHospital(hospital);
		
		structure.setMessage("successfullyn saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(hospital);

		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		Hospital daohHospital = hospitaldao.updaHospital(id, hospital);
		if (daohHospital != null) {
			structure.setMessage("successfylly upadted:");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daohHospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);

		} else

		{
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id)
		{	ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		
		Hospital daoHospital=hospitaldao.deleteHospital(id);
		if(daoHospital!=null)
		{
			structure.setMessage("successfylly deleted:");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		
		}else
		{
			throw new IdNotFoundException();
		}

}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id)
	{
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		Hospital daHospital=hospitaldao.getHospital(id);
		if(daHospital!=null)
		{
			structure.setMessage("successfylly found:");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		else
		{
			throw new   IdNotFoundException();
		}
	}

}
