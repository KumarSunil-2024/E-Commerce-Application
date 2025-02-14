package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long>{

	public Admin findByEmail(String email);
}
