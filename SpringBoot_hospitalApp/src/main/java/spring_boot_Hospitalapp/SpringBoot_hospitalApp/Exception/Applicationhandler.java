package spring_boot_Hospitalapp.SpringBoot_hospitalApp.Exception;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import spring_boot_Hospitalapp.SpringBoot_hospitalApp.Services.HospitalServices;
import spring_boot_Hospitalapp.SpringBoot_hospitalApp.util.ResponseStructure;

@ControllerAdvice
public class Applicationhandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionhnadler(IdNotFoundException ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("no hospital found for given id");
		return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionHandler(NoSuchElementException ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("no hospital found for given id in GetMethod");
		
			return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND); 
		
	}
	
	
	       @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	    		HttpHeaders headers, HttpStatus status, WebRequest request) {
	    	
	    	   
	    	   List<ObjectError> error=ex.getAllErrors();
	    	   Map<String , String> map=new LinkedHashMap<String , String>();
	    	   
	    	   for(ObjectError er:error)
	    	   {
	    		   String fieldName=((FieldError)er).getField();
	    		   String messsager=  ((FieldError)er).getDefaultMessage();
	    		   map.put(fieldName, messsager);
	    	   }
	    	return new ResponseEntity<Object>(map , HttpStatus.BAD_REQUEST);
	    }
	       
	       @ExceptionHandler(IdNotFoundForBranchException.class)
	       public ResponseEntity<ResponseStructure<String>> idNotFoundForBranchException(IdNotFoundForBranchException re)
	       {
	    	   
	    	   ResponseStructure<String> structure=new ResponseStructure<>();
	    	   structure.setMessage(re.getMessage());
	    	   structure.setData("no brach found for  id" );
	    	   structure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND);
	    	   
	       }
	       
	       
	       @ExceptionHandler(IdNotFoundForPersonException.class)
	       public ResponseEntity<ResponseStructure<String>> idNoTFoundForPerson(IdNotFoundForPersonException exception)
	       {
	    	   ResponseStructure<String> structure=new ResponseStructure<>();
	    	   structure.setMessage(exception.getMessage());
	    	   structure.setData("no person present  found for  id" );
	    	   structure.setStatus(HttpStatus.NOT_FOUND.value());
	    	   return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND); 
	       }
	       
	       @ExceptionHandler(IdNotFoundForEncounter.class)
	      public ResponseEntity<ResponseStructure<String>> idNotFoundForEncounter(IdNotFoundForEncounter encounter)
	      {
	    	   ResponseStructure<String> structure=new ResponseStructure<>();
	    	   structure.setMessage(encounter.getMessage());
	    	   structure.setData("no encounter present  found for  id" );
	    	   structure.setStatus(HttpStatus.NOT_FOUND.value());
	    	   return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND);
	    	  
	      }
	    
	       
//	       public ResponseEntity<Object> handlecontraintViolationException(ConstraintViolation)
	       
	       
	      
	       
	       
	       
}
