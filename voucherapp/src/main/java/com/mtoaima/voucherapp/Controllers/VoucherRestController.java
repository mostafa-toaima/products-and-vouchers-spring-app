package com.mtoaima.voucherapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtoaima.voucherapp.model.Voucher;
import com.mtoaima.voucherapp.repos.VoucherRepository;

@RestController
@RequestMapping("/voucherapi")
public class VoucherRestController {

	@Autowired
	VoucherRepository repo;
	
	
	@PostMapping("/vouchers")
	public Voucher create(@RequestBody Voucher voucher ) {
		return repo.save(voucher);
	}
	
	@GetMapping("/vouchers/{code}")
	public Voucher getVoucher(@PathVariable("code") String code ) {
		return repo.findByCode(code);
	}
}
