package com.mtoaima.voucherapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtoaima.voucherapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
