package com.bitcode.personalcourses.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.Institution;
import com.bitcode.personalcourses.services.InstitutionService;

@CrossOrigin(origins = {"*", "null"})
@RestController
@RequestMapping("/api")
public class InstitutionController {
	
	private InstitutionService institutionService;
	private static final Logger logger = LoggerFactory.getLogger(InstitutionController.class);
	
	@Autowired
	public void setInstitutionService(InstitutionService instService) {
		
		this.institutionService = instService;
	}
	
	@GetMapping("/Institutions")
	public List<Institution> getInstitutions() throws ResourceNotFoundException {
		logger.debug("/Institutions Get");
		List<Institution> il = institutionService.getAllInstitutions();
		if(il.isEmpty()) {
			throw new  ResourceNotFoundException("Institution is not found.");
		}
		
		return il;
	}
	
	@PostMapping("/Institutions")
	public Institution postInstitution(@Valid @RequestBody Institution inst) {
		
		return institutionService.createInstitution(inst);
	}
	
	@GetMapping("/Institutions/{ID}")
	public Institution getInstitutionById(@PathVariable(value="ID") Long inst_id) throws ResourceNotFoundException {
		
		Institution ist =  institutionService.getInstitution(inst_id);
		
		if(ist == null) {
			throw new  ResourceNotFoundException("Institution is not found.");
		}
		
		return ist;
	}
	
	@DeleteMapping("/Institutions/{ID}")
	public Institution deleteInstitutionById(@PathVariable(value="ID") Long inst_id)
		throws ResourceNotFoundException {
		
		Institution inst = institutionService.deleteInstitution(inst_id);
		
		if(inst == null) {
			throw new ResourceNotFoundException("Institution is not found.");
		}
				
		return inst;
	}
	
	@PutMapping("/Institutions/{ID}")
	public Institution updateInstitutionById(@PathVariable(value="ID") Long id, @Valid @RequestBody Institution inst)  throws ResourceNotFoundException {
		
		inst.setID(id);
		Institution old_inst = institutionService.updateInstitution(inst);
		
		if(old_inst == null) {
			throw new  ResourceNotFoundException("Institution is not found.");
		}
		
		return old_inst;
	}

}
