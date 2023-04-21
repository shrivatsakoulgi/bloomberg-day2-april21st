package com.bloomberg.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bloomberg.springbootdemo.entity.Share;

@RestController
public class MyController {
	
	private static List<Share> shares;
	
	static {
		shares = new ArrayList<>();
		shares.add(new Share("ADANI", 1817.40,12.2,1500.2));
		shares.add(new Share("ITC", 401.10,0.9,980.3));
		shares.add(new Share("GAIL", 101.65,1.12,650.8));
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "Good Morning.!! This is First Springboot app..!!";
	}
	
	@GetMapping("/share/{shareName}")
	public Share getShareByName(@PathVariable String shareName) {
		return shares.stream().filter(s->s.getShareName().equalsIgnoreCase(shareName))
				.findAny().get();
				
	}
	
	@GetMapping("/share")
	public List<Share> getAllShares(){
		return shares;
	}
	
	@PostMapping("/share")
	public ResponseEntity<String> addShare(@RequestBody Share share){
		shares.add(share);
		return new ResponseEntity<>(share.getShareName()+ " Share is added successfully..",HttpStatus.OK);	
	}

	@DeleteMapping("/share/{shareName}")
	public ResponseEntity<String> deleteShareByName(@PathVariable String shareName){	
		shares.remove(getShareByName(shareName));
		return new ResponseEntity<>(shareName+ " Share is deleted successfully..",HttpStatus.OK);
	}

	
	@PutMapping("/share/{shareName}")
	public ResponseEntity<String> updateShareDetails(@PathVariable String shareName, @RequestBody Share updatedShare){
		getShareByName(shareName).setSharePrice(updatedShare.getSharePrice());
		getShareByName(shareName).setEquityDebtRatio(updatedShare.getEquityDebtRatio());
		getShareByName(shareName).setTotalInvestmentsInCrores(updatedShare.getTotalInvestmentsInCrores());
		return new ResponseEntity<>(shareName+ " Share is updated successfully..",HttpStatus.OK);	
	}
}
