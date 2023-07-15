package spring_boot_Hospitalapp.SpringBoot_hospitalApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.AddressService;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Address;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@RestController
public class AddressContoller {


	@Autowired
	private AddressService service;

	@ApiOperation(value = "store addresss"  , notes = "api used to store the address ")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "address saved"),
			@ApiResponse(code = 404 , message = "not found")
			
			
	})
	
	
	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return service.saveAddress(address);
	}

	@ApiOperation(value = "store addresss"  , notes = "api used to store the address ")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "address saved"),
			@ApiResponse(code = 404 , message = "not found")})
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id,
			@RequestBody Address address) {
		return service.updateAddress(id, address);
	}

	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
		return service.deleteAddress(id);
	}
	@ApiOperation(value = "store addresss"  , notes = "api used to store the address ")
	@ApiResponses(value= {@ApiResponse(code = 302, message = "address saved"),
			@ApiResponse(code = 404 , message = "not found")})

	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id) {
		return service.getAddressById(id);
	}

}
