package com.mtoaima.voucherapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtoaima.voucherapp.model.Voucher;
import com.mtoaima.voucherapp.repos.VoucherRepository;

@Controller
public class VoucherController {
	
	@Autowired
	private VoucherRepository repo;
	
	@GetMapping("/showCreateVoucher")
	public String showCreateVoucher() {
		return "createVoucher";
	}
	
	@PostMapping("saveVoucher")
	public String save(Voucher voucher) {
		repo.save(voucher);
		return "createResponse";
	}
	
	@GetMapping("/showGetVoucher")
	public String showGetVoucher() {
		return "getVoucher";
	}
	
	@PostMapping("getVoucher")
	public ModelAndView getVoucher(String code) {
		ModelAndView mav = new ModelAndView("VoucherDetails");
		System.out.println(code);
		mav.addObject(repo.findByCode(code));
		return mav;
	}

}
