package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.User;

public interface UserRepo extends JpaRepository<User,Long>{

	public User findByEmail(String email);
}

