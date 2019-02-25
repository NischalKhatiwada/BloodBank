package com.info.bloodBank.BloodBank.service;

import java.util.List;
import java.util.Optional;

import com.info.bloodBank.BloodBank.entity.BloodBank;;

public interface IBloodBankService {
	public BloodBank addBloodBank(BloodBank bb);

	public List<BloodBank> getAllBloodBank();

	public Optional<BloodBank> getBloodBankById(Integer bloodBankId);

	public void deleteBloodBank(Integer bloodBankId);

	public void deleteAllBloodBank();

	public void updateBloodBank(Integer bloodBankId, BloodBank bb);
}