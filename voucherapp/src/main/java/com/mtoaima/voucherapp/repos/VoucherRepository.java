package com.mtoaima.voucherapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtoaima.voucherapp.model.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

	Voucher findByCode(String code);
}
