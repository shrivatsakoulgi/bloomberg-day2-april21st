package com.bloomberg.springbootjpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bloomberg.springbootjpa.dao.ShareDAO;
import com.bloomberg.springbootjpa.entity.Share;

@RestController
public class ShareController {
	@Autowired
	private ShareDAO shareDao;
		
	@GetMapping("/share/{shareName}")
	public Share getShareByName(@PathVariable String shareName) {
		// DB call
		return shareDao.findById(shareName).get();			
	}
	
	@GetMapping("/share")
	public List<Share> getAllShares(){
		// Get all Share objects
		return (List<Share>)shareDao.findAll();	
	}
	
	@PostMapping("/share")
	public ResponseEntity<String> addShare(@RequestBody Share share){
		// insert into statement
		shareDao.save(share);
		return new ResponseEntity<>(share.getShareName()+ 
				" Share is added successfully..",HttpStatus.OK);	
	}

	@DeleteMapping("/share/{shareName}")
	public ResponseEntity<String> deleteShareByName
	(@PathVariable String shareName){	
		shareDao.deleteById(shareName);
		return new ResponseEntity<>(shareName+ 
				" Share is deleted successfully..",HttpStatus.OK);
	}
	
	@PutMapping("/share/{shareName}")
	public ResponseEntity<String> updateShareDetails
	(@PathVariable String shareName, @RequestBody Share updatedShare){
		shareDao.updateShare(shareName, updatedShare.getSharePrice(),
				updatedShare.getEquityDebtRatio(), 
				updatedShare.getTotalInvestmentsInCrores());
		//shareDao.save(updatedShare);
		return new ResponseEntity<>(shareName+ 
				" Share is updated successfully..",HttpStatus.OK);	
	}
	
	@GetMapping("/share/price/{sharePrice}")
	public Share getBySharePrice(@PathVariable double sharePrice) {
		return shareDao.findBySharePrice(sharePrice).get();
	}
}
