package spring_boot_Hospitalapp.SpringBoot_hospitalApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Repo.AddressRepo;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Address;

@Repository
public class Addressdao {

	@Autowired
	private AddressRepo addressRepo;

	public Address saveAddress(Address address)

	{

		return addressRepo.save(address);
	}

	public Address updateAddresss(int id, Address address) {
		if (addressRepo.findById(id).isPresent()) {

			address.setId(id);
			return addressRepo.save(address);
		} else {
			return null;
		}

	}

	public Address deleteAddress(int id) {
		if (addressRepo.findById(id).isPresent()) {
			Address address = addressRepo.findById(id).get();
			addressRepo.deleteById(id);
			return address;

		} else {
			return null;
		}
	}

	public Address getAddressById(int id) {
		if (addressRepo.findById(id).isPresent()) {
			return addressRepo.findById(id).get();
		} else
			return null;

	}

}
