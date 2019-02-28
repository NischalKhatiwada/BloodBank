package com.info.bloodBank.BloodBank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.bloodBank.BloodBank.entity.BloodBank;
import com.info.bloodBank.BloodBank.repository.BloodBankRepository;
import com.info.bloodBank.BloodBank.service.IBloodBankService;



@Service
public class BloodBankServiceImp implements IBloodBankService{	

@Autowired
private BloodBankRepository bloodBankRepository;

@Override
public BloodBank addBloodBank(BloodBank bloodBank) {
	BloodBank savedBloodBank = bloodBankRepository.save(bloodBank);
	return savedBloodBank;

}

@Override
public List<BloodBank> getAllBloodBank(){
	List<BloodBank> allBloodBank = bloodBankRepository.findAll();
	return allBloodBank;
}

@Override
public Optional<BloodBank> getBloodBankById(Integer bloodBankId){
	Optional<BloodBank> BloodBankById = bloodBankRepository.findById(bloodBankId);
	return BloodBankById;
}

@Override
public void deleteBloodBank(Integer bloodBankId) {
	bloodBankRepository.deleteById(bloodBankId);
}

@Override
public void deleteAllBloodBank() {
	bloodBankRepository.deleteAll();
}

@Override
public void updateBloodBank(Integer bloodBankId, BloodBank updatedBloodBank) {
	BloodBank bloodBank = bloodBankRepository.getOne(bloodBankId);
	bloodBank.setId(bloodBankId);
	bloodBankRepository.save(updatedBloodBank);
}
}