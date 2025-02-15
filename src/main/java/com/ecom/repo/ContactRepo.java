package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Message;

public interface ContactRepo extends JpaRepository<Message, Long> {

}