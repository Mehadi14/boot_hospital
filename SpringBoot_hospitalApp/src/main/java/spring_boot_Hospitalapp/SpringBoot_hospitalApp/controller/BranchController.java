package spring_boot_Hospitalapp.SpringBoot_hospitalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.BranchServices;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.dto.Branch;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	private BranchServices branchServices;
    @ApiOperation(value = "save branch ", notes="Api is used to save the branch with given hospital id")
   @ApiResponses(value = {@ApiResponse(code=201 , message = "Succesfully Created"),
		   @ApiResponse(code = 404 , message = "Id not found for the given Hospital Id")
		   
   })
	@PostMapping("/branch")
   
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @RequestParam int hid,
			@RequestParam int aid) {
		return branchServices.saveBranch(branch, hid, aid);

	}
    @ApiOperation(value = "update branch", notes="Api is used to up")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "updated success"),
    		@ApiResponse(code=204, message = "problem on update")
    		
    })

	@PutMapping("/branch")     
	public ResponseEntity<ResponseStructure<Branch>> upadteBranch(@RequestBody Branch branch, @RequestParam int bid,
			@RequestParam int aid) {
		return branchServices.updateBranch(branch, bid, aid);

	}
    
    @ApiOperation(value = "fetch brach", notes = "fetch branch by id")
    @ApiResponses(value = {@ApiResponse(code = 200 ,message = "fetched successfully"),
    		      @ApiResponse(code = 404,message = "id not found for given batch")
    		
    })

	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getBrach(@RequestParam int bid) {
		return branchServices.getBranch(bid);
	}
    @ApiOperation(value = "delete", notes="delete branch by id")
    @ApiResponses(value = {@ApiResponse(code = 204 , message = "successfully deleted"),
    @ApiResponse(code = 404, message = "not found")
    		
    })

	@DeleteMapping("/branch/{bid}")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int bid) {
		return branchServices.deleteBranch(bid);
	}
    @ApiOperation(value = "fetch brach", notes = "fetch branch by hospital id")
    @ApiResponses(value = {@ApiResponse(code = 200 ,message = "fetched successfully"),
    		      @ApiResponse(code = 404,message = "id not found for given batch")
    		
    })

	@GetMapping("/branch1/{hid}")
	public ResponseEntity<ResponseStructure<List<Branch>>> getbrancByHospital(@PathVariable int hid) {
		return branchServices.getBranchByhospital(hid);
	}
    
    @GetMapping("/branch/{manager}")
    public ResponseEntity<ResponseStructure<List<Branch>>> findByManager(@PathVariable String manager)
    {
		return branchServices.findByManager(manager);
    	
    }

}
