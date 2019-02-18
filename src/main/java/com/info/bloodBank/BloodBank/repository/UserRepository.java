package com.info.bloodBank.BloodBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.bloodBank.BloodBank.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
