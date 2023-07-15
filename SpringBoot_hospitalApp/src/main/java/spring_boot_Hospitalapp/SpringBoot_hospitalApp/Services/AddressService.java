package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception.IdNotFoundException;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao.Addressdao;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Address;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	private Addressdao addressdao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(addressdao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		Address dbAddress = addressdao.updateAddresss(id, address);
		if (dbAddress != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException(" Id not found for address");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address = addressdao.deleteAddress(id);
		if (address != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException(" Id not found for address");
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {
		Address address=addressdao.getAddressById(id);
		if (address != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException(" Id not found for address");
		}
	}



}
