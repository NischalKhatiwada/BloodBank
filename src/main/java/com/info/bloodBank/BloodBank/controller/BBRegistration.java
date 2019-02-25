package com.info.bloodBank.BloodBank.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.info.bloodBank.BloodBank.entity.BloodBank;
import com.info.bloodBank.BloodBank.entity.User;
import com.info.bloodBank.BloodBank.service.impl.BloodBankServiceImp;

@RestController
@RequestMapping(value = "/api/bloodbank")

public class BBRegistration{
	@Autowired
	private BloodBankServiceImp bloodBankService;
	
	@PostMapping(value = "/addBloodBank")
	public ResponseEntity<Object> addBloodBank(@RequestBody BloodBank bb) {
		BloodBank savedBloodBank = (BloodBank) bloodBankService.addBloodBank(bb);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBloodBank.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}	
	
	
	@GetMapping(value = "/allBloodBank")
	public ResponseEntity<List<BloodBank>> getAllBloodBank() {
		List<BloodBank> allBloodBank= bloodBankService.getAllBloodBank();
		if (allBloodBank.isEmpty()) {
			return new ResponseEntity<List<BloodBank>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BloodBank>>(allBloodBank, HttpStatus.OK);
	}

	@GetMapping(value = "/BloodBankById/{BloodBankId}")
	public ResponseEntity<Optional<BloodBank>> getUserById(@PathVariable("BloodBankId") Integer BloodBankId) {
		Optional<BloodBank> BloodBankById = bloodBankService.getBloodBankById(BloodBankId);
		if (!BloodBankById.isPresent()) {
			return new ResponseEntity<Optional<BloodBank>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<BloodBank>>(BloodBankById, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteBloodBank/{BloodBankId}")
	public ResponseEntity<Optional<BloodBank>> deleteBloodBank(@PathVariable(value = "BloodBankId") Integer BloodBankId) {
		Optional<BloodBank> BloodBankById = bloodBankService.getBloodBankById(BloodBankId);
		if (!BloodBankById.isPresent()) {
			return new ResponseEntity<Optional<BloodBank>>(HttpStatus.NOT_FOUND);
		}
		bloodBankService.deleteBloodBank(BloodBankId);
		return new ResponseEntity<Optional<BloodBank>>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAllBloodBank")
	public ResponseEntity<BloodBank> deleteAllBloodBank() {
		bloodBankService.deleteAllBloodBank();
		return new ResponseEntity<BloodBank>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/updateBloodBank/{BloodBankId}")
	public ResponseEntity<Optional<BloodBank>> updateBloodBank(@PathVariable(value = "BloodBankId") Integer BloodBankId,
			@RequestBody BloodBank updatedBloodBank) {
		Optional<BloodBank> BloodBankById = bloodBankService.getBloodBankById(BloodBankId);
		if (!BloodBankById.isPresent()) {
			return new ResponseEntity<Optional<BloodBank>>(HttpStatus.NOT_FOUND);
		}
		bloodBankService.updateBloodBank(BloodBankId, updatedBloodBank);
		return new ResponseEntity<Optional<BloodBank>>(HttpStatus.OK);
	}
}